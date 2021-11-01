package coffee.machine.beverages;

import coffee.machine.ingredients.Ingredient;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class BeverageIngredientData {
    Map<Ingredient, Integer> map;
    String beverageName;
    public BeverageIngredientData(Map<Ingredient, Integer> map, String beverageName) {
        this.map = map;
        this.beverageName = beverageName;
    }

}
