package coffee.machine;

import coffee.machine.module.CoffeeMachineModule;
import coffee.machine.order.CoffeeOrder;
import coffee.machine.order.PlaceOrderFromConsole;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import lombok.Data;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

public class CoffeeMachineApplication {

    @Data
    @JsonIgnoreProperties
    public static class Test{
        @JsonProperty("total_items_quantity")
        Map<String , Integer> map;
    }
    public void read() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("input.json");
        CoffeeMachineInput test = mapper.readValue(inputStream, CoffeeMachineInput.class);
        System.out.println(mapper.writeValueAsString(test));
    }

    public static void main(String[] args) throws IOException {

        Injector injector = Guice.createInjector(new CoffeeMachineModule());
        CoffeeOrder order = injector.getInstance(PlaceOrderFromConsole.class);
        order.StartOrder();
    }
}
