package producerConsumer;

import java.util.*;

public class BrokerImpl<T> implements Broker<T> {
    Set<String> producerIds;
    Map<String, Set<Consumer>> consumerList;

    public BrokerImpl() {
        producerIds = new HashSet<>();
        consumerList = new HashMap<>();
    }

    @Override
    public List<String> getProducerList() {
        return new ArrayList<>(producerIds);
    }

    @Override
    public void registerProducer(String producer) {
        producerIds.add(producer);
    }

    @Override
    public void publishMsg(String producer, T msg) {
        if (consumerList.containsKey(producer)) {
            for (Consumer each : consumerList.get(producer)) {
                each.consume(msg);
            }
        }
    }

    @Override
    public void subscribe(String producer, Consumer<T> consumer) {
        Set<Consumer> consumers = consumerList.getOrDefault(producer, new HashSet<>());
        consumers.add(consumer);
        consumerList.put(producer, consumers);
    }

    @Override
    public void unSubscribe(String producer, Consumer<T> consumer) {
        if (consumerList.containsKey(producer)) {
            consumerList.get(producer).remove(consumer);
        }
    }
}
