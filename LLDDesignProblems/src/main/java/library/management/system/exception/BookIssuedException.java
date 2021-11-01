package library.management.system.exception;

public class BookIssuedException extends Exception {

    public BookIssuedException(String msg, Exception e) {
        super(msg, e);
    }
    public BookIssuedException(String msg) {
        super(msg);
    }
}
