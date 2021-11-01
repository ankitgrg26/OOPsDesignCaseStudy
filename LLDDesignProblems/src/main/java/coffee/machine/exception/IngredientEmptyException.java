package coffee.machine.exception;

public class IngredientEmptyException extends RuntimeException {

    public IngredientEmptyException(String errorMsg) {
        super(errorMsg);
    }
}
