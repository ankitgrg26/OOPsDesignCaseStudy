package coffee.machine.ingredients;

import coffee.machine.exception.IngredientEmptyException;

public interface Ingredient {

    /**
     * It fills the current ingredients buffer and returns the overflow
     * @param amount
     * @return
     */
    int fill(int amount);

    /**
     * gives the use notification for empty container
     */
    void notifyEmpty() ;

    /**
     *
     * @param quantity : mount of ingredient to be consumed.
     */
    void consume(int quantity) throws IngredientEmptyException;

    int get();

    String getName();
}
