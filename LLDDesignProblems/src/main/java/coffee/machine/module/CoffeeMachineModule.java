package coffee.machine.module;

import coffee.machine.CoffeeMachineInput;
import coffee.machine.beverages.BeverageIngredientData;
import coffee.machine.ingredients.Ingredient;
import coffee.machine.ingredients.IngredientImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;

import javax.inject.Named;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class CoffeeMachineModule extends AbstractModule {
    @Override
    protected void configure() {

    }

    @Provides
    @Singleton
    public ObjectMapper provideObjectMapper() {
        return new ObjectMapper();
    }

    @Provides
    @Singleton
    public CoffeeMachineInput provideCoffeeMachineInput(ObjectMapper mapper) throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("input.json");
       /* String text = new BufferedReader(
                new InputStreamReader(inputStream, StandardCharsets.UTF_8))
                .lines()
                .collect(Collectors.joining("\n"));
        System.out.print(text);
        return null;

        */
        CoffeeMachineInput coffeeMachineInput = mapper.readValue(inputStream, CoffeeMachineInput.class);
        inputStream.close();
        return coffeeMachineInput;
    }

    @Provides
    @Singleton
    @Named("IngredientMap")
    public Map<String, Ingredient> provideIngredientMap(CoffeeMachineInput input) {
        List<Integer> list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>(list);
        Map<String, Ingredient> ingredientMap = new HashMap<>();
        input.getMachine().getQuantity().forEach((k, v) -> {
            ingredientMap.put(k, new IngredientImpl(k, v));
        });
        return ingredientMap;
    }

    @Provides
    @Singleton
    @Named("BeverageMap")
    public Map<String, BeverageIngredientData> provideBeverageMap(CoffeeMachineInput input,
                                                                  @Named("IngredientMap") Map<String, Ingredient> ingredientMap) {
        Map<String, BeverageIngredientData> BeverageMap = new HashMap<>();
        input.getMachine().getBeverages().forEach((beverageName, ingredientRequired) -> {
            Map<Ingredient, Integer> ingredientQuantityMap = new HashMap<>();
            ingredientRequired.forEach((ingredient, size) -> {
                ingredientQuantityMap.put(ingredientMap.get(ingredient), size);
            });
            BeverageIngredientData beverageIngredientData = new BeverageIngredientData(ingredientQuantityMap, beverageName);
            BeverageMap.put(beverageName, beverageIngredientData);
        });
        return BeverageMap;
    }

    @Provides
    @Singleton
    @Named("CoffeeMachineOutlet")
    public ExecutorService provideCoffeeOutlet(CoffeeMachineInput input) {
        return Executors.newFixedThreadPool(input.getMachine().getOutlets().getCount());
    }
}
