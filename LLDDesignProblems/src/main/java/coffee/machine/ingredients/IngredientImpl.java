package coffee.machine.ingredients;

import coffee.machine.exception.IngredientEmptyException;
import lombok.Synchronized;

public class IngredientImpl implements Ingredient {
    private int quantity;
    private final int maxSize;
    private final String ingredientType;

    public IngredientImpl(String ingredientType, int maxSize) {
        this.quantity = maxSize;
        this.maxSize = maxSize;
        this.ingredientType = ingredientType;
    }


    @Override
    @Synchronized
    public int fill(int amount) {
        quantity = quantity + amount;
        if (quantity > maxSize) {
            return quantity - maxSize;
        }
        return 0;
    }

    @Override
    public void notifyEmpty() {
        System.out.println(ingredientType + " is empty.");
    }

    @Override
    @Synchronized
    public void consume(int amount) throws IngredientEmptyException {
        if (quantity - amount < 0) {
            throw new IngredientEmptyException(ingredientType + " is not present");
        }
        quantity = quantity - amount;
    }

    @Override
    public int get() {
        return quantity;
    }

    @Override
    public String getName() {
        return ingredientType;
    }

}
