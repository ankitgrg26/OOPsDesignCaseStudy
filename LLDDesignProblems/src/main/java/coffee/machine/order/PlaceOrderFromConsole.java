package coffee.machine.order;

import coffee.machine.CoffeeMachine;
import coffee.machine.ingredients.Ingredient;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Map;
import java.util.Scanner;

public class PlaceOrderFromConsole implements CoffeeOrder {
    private final CoffeeMachine machine;
    private final Scanner sc;
    private final Map<String, Ingredient> map;

    @Inject
    public PlaceOrderFromConsole(final CoffeeMachine machine, @Named("IngredientMap") Map<String, Ingredient> map) {
        this.machine = machine;
        sc = new Scanner(System.in);
        this.map = map;

    }

    @Override
    public void StartOrder() {
        while(true) {
            String type = sc.next();
            if(type.equals("print")) {
                map.forEach((k,v) -> {
                    System.out.println(k+" "+v.get());
                });
                continue;
            }
            machine.prepareBeverage(type);
        }

    }
}
