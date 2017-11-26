package exception;

public class CantReadException extends RuntimeException {

    public CantReadException(String message) {
        super(message);
        System.out.println(message);
    }

}
