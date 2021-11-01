package producerConsumer;

public interface Producer<T> {

    void produce(T msg);

}
