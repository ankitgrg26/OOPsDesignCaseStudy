package RateLimiter;

import lombok.Synchronized;

import java.util.*;

public class SlidingWindow {
    private final long duration;
    private final long rate;
    private Deque<Long> dqueue;

    public SlidingWindow(long durationInMilli, long rate ) {
        this.duration = durationInMilli;
        this.rate = rate;
        dqueue = new LinkedList<>();

    }

    @Synchronized
    public boolean checkRequest(String request) {
        List<Integer> list = new ArrayList<>();
        long currTime = System.currentTimeMillis();
        while(!dqueue.isEmpty() && dqueue.peekFirst() <= currTime - duration) {
            dqueue.pollFirst();
        }
        if(dqueue.size() < rate) {
            dqueue.addLast(currTime);
            System.out.println(request+" success");
            return true;
        }
        System.out.println(request+" fail");
        return false;
    }


    public static void main(String[] args) {
        SlidingWindow slidingWindow = new SlidingWindow(1000, 10);
        int numberOfThreads = 10;
        int numberOfRequest = 10;
        Thread[] threads = new Thread[numberOfThreads];

        for(int i = 0; i < numberOfThreads; i++) {
            final String threadNumber = "Thread "+i;
            threads[i] = new Thread(() -> {
                int[] count = new int[2];
                for(int j = 0; j < numberOfRequest; j++) {
                   boolean result =  slidingWindow.checkRequest(threadNumber+" request "+j);
                    try {
                        long rand = (long)(Math.random()*500);
                        Thread.sleep(rand);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if(result) {
                       count[0]++;
                   } else {
                       count[1]++;
                   }
                }
                //System.out.println(threadNumber+" success "+count[0]+" failure "+count[1]);
            });
        }
        for(int i = 0; i < numberOfThreads; i++) {
            threads[i].start();
        }
    }

}
