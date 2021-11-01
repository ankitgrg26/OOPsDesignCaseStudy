package coffee.machine.beverages;

import coffee.machine.exception.IngredientEmptyException;
import coffee.machine.ingredients.Ingredient;

import javax.annotation.processing.SupportedSourceVersion;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Beverage implements Runnable {

    BeverageIngredientData beverageData;

    public Beverage(BeverageIngredientData beverageIngredientData) {
        this.beverageData = beverageIngredientData;
    }

    public void run() {

        List<Ingredient> ingredients = new ArrayList<>();
        Set<Ingredient> set =beverageData.getMap().keySet();
        System.out.println("Starting to prepare "+beverageData.toString());
        boolean isError = false;
        for(Ingredient each : set) {
            try {
                int quantity = beverageData.getMap().get(each);
                System.out.println("consuming "+each.getName()+" quantity "+quantity);
                each.consume(quantity);
                ingredients.add(each);
            } catch (IngredientEmptyException e) {
                each.notifyEmpty();
                ingredients.forEach((eachVal) -> eachVal.fill(beverageData.getMap().get(eachVal)));
                isError = true;
                break;
            }

        }
        if(!isError)
            displaySuccess();
        else
            System.out.println("Unable to serve "+beverageData.beverageName);
    }

    private void displaySuccess() {
        System.out.println("here is your "+beverageData.beverageName);
    }

}
