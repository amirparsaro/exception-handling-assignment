package exceptions;

public class InvalidBookException extends Exception {
    public InvalidBookException(String errorMessage) {
        super(errorMessage);
    }
}
