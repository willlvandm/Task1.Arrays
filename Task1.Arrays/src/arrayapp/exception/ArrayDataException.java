package arrayapp.exception;
public class ArrayDataException extends Exception {

    public ArrayDataException(String message) {
        super(message);
    }

    public ArrayDataException(String message, Throwable cause) {
        super(message, cause);
    }
}
