package coffee.machine.factory;

import coffee.machine.beverages.Beverage;
import coffee.machine.beverages.BeverageIngredientData;
import coffee.machine.exception.BeverageNotFoundException;
import coffee.machine.ingredients.Ingredient;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Map;

public class BeverageFactory {
    Map<String, Ingredient> ingredientMap;
    Map<String, BeverageIngredientData> beverageIngredientDataMap;


    @Inject
    public BeverageFactory(@Named("IngredientMap") Map<String, Ingredient> map,
                           @Named("BeverageMap") Map<String, BeverageIngredientData> beverageIngredientDataMap) {
        this.ingredientMap = map;
        this.beverageIngredientDataMap = beverageIngredientDataMap;
    }

    public Runnable getBeverageRunnable(String type) {
        if(beverageIngredientDataMap.containsKey(type))
            return new Beverage(beverageIngredientDataMap.get(type));
        else
            throw new BeverageNotFoundException("Beverage "+type+" not found");
    }
}
