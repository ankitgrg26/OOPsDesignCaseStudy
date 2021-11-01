package producerConsumer;

public interface Consumer<T> {

    public void consume(T msg);
}
