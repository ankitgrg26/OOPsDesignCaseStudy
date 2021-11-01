package producerConsumer;

public class TestProducerConsumer {

    public static void main(String[] args) {
        int pNumber = 10;
        int count = 10000;
        long delay = 100;
        int cNumber = 10;
        Broker<String> broker = new BrokerImpl<>();
        Producer<String>[] producers = new Producer[pNumber];
        Consumer<String>[] consumers = new Consumer[cNumber];

        Thread[] producerThread = new Thread[pNumber];
        Thread[] consumerThread = new Thread[cNumber];

        for (int i = 0; i < pNumber; i++) {
            String producerNumber = "" + i;
            final int localCount = count;
            producerThread[i] = new Thread(() -> {
                Producer<String> producer = new ProducerImpl<String>(broker, producerNumber);
                for (int j = 0; j < localCount; j++) {
                    producer.produce("msg from " + producerNumber + " " + j);
                    try {
                        Thread.sleep(delay);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }

    }
}
