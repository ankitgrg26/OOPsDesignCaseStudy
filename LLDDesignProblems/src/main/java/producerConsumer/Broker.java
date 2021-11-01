package producerConsumer;

import java.util.List;

public interface Broker<T> {

    List<String> getProducerList();

    void registerProducer(String producer);

    void publishMsg(String producer, T msg);

    void subscribe(String producer, Consumer<T> consumer);

    void unSubscribe(String producer, Consumer<T> consumer);


}
