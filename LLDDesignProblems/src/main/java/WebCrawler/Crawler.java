package WebCrawler;

import sun.awt.windows.ThemeReader;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;


/**
 * // This is the HtmlParser's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface HtmlParser {
 * public List<String> getUrls(String url) {}
 * }
 */

class Crawler {
    Set<String> set;
    AtomicInteger atm = new AtomicInteger(1);
    int threadSize = 5;
    String hostname;
    HtmlParser htmlParser;
    ExecutorService executor;

    public class Task implements Runnable {
        String url;
        public Task(String url) {
            this.url = url;
        }

        @Override
        public void run() {
            if (set.contains(url) || hostname != getHostName(url)) {
                return;
            }
            set.add(url);
            List<String> list = htmlParser.getUrls(url);
            for (String each : list) {
                atm.addAndGet(1);
                executor.submit(new Task(each));
            }
            atm.decrementAndGet();
        }
    }

    public List<String> crawl(String startUrl, HtmlParser htmlParser) throws InterruptedException {
        long start = System.currentTimeMillis();
        hostname = getHostName(startUrl);
        set = Collections.synchronizedSet(new HashSet<>());
        executor = Executors.newFixedThreadPool(threadSize);
        executor.submit(new Task(startUrl));
        while (atm.get() != 0) {
            Thread.sleep(50);
        }
        executor.shutdown();
        return new ArrayList<>(set);
    }


    public String getHostName(String s) {
        int count = 0;
        int i = 0;
        while (i < s.length() && count < 3) {
            if (s.charAt(i) == '/') {
                count++;
            }
            if (count == 3) {
                break;
            }
            i++;
        }
        return s.substring(0, i);
    }

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.submit(() -> {
            System.out.println("Thread1 start");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            countDownLatch.countDown();
            System.out.println("Thread1 End");
        });
        executor.submit(() -> {
            System.out.println("Thread2 start");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            countDownLatch.countDown();
            System.out.println("Thread2 End");
        });
        countDownLatch.await();
        System.out.println("End");
        executor.shutdown();
    }

}