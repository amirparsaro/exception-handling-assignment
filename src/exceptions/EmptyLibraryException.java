package exceptions;

public class EmptyLibraryException extends Exception {
    public EmptyLibraryException(String errorMessage) {
        super(errorMessage);
    }
}
