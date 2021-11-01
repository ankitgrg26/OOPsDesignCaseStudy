package producerConsumer;

public class ProducerImpl<T> implements Producer<T> {
    private final Broker broker;
    private final String producerId;

    public ProducerImpl(Broker broker, String producerId) {
        this.broker = broker;
        this.producerId = producerId;
        broker.registerProducer(producerId);
    }

    @Override
    public void produce(T msg) {
        broker.publishMsg(producerId, msg);
    }
}
