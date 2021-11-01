package producerConsumer;

public class ConsumerImpl<T> implements Consumer<T> {

    @Override
    public void consume(T msg) {
        System.out.println(msg.toString());
    }
}
