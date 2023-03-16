package homer.common.bounds;

/**
 * This exception indicates that lower and upper boundary numbers were passed in
 * an incorrect order.
 */
public class InvertedBoundsException extends RuntimeException {

    @java.io.Serial
    private static final long serialVersionUID = 1L;

    /**
     * Constructs an {@code InvertedBoundsException} with no message.
     */
    public InvertedBoundsException() {
        super();
    }

    /**
     * Constructs an {@code InvertedBoundsException} with an error message.
     * 
     * @param message the error message
     */
    public InvertedBoundsException(final String message) {
        super(message);
    }

}
