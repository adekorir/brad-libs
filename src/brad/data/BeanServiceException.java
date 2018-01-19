package brad.data;

public class BeanServiceException extends Exception {

    public BeanServiceException() {
        super();
    }

    public BeanServiceException(String message) {
        super(message);
    }

    public BeanServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public BeanServiceException(Throwable cause) {
        super(cause);
    }
}
