package coffee.machine.exception;

public class BeverageNotFoundException extends RuntimeException {

    public BeverageNotFoundException(String errorMsg) {
        super(errorMsg);
    }
}