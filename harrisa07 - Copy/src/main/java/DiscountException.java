/**
 * Created by Alex on 3/16/14.
 */
public class DiscountException extends Exception {

    /**
     * Constructs a new DiscountException with an unspecific message.
     */
    public DiscountException() {
        super("Discount Exception.");
    }

    /**
     * Constructs a new DiscountException with the specified detail message.
     * @param message Message describing the exception
     */
    public DiscountException(final String message){
        super(message);
    }
}
