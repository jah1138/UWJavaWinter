/**
 * Exception that can be thrown when a class violates discount rules.
 * Author: Alex Harris
 * Version: 3/16/14.
 */
public class DiscountException extends Exception {

    /**
     * This property was defined in the instructions, so here it is.
     */
    private InvoiceItem problemItem = null;

    /**
     * Constructs a new DiscountException with an non-specific message.
     */
    public DiscountException(String message) {
        super(message);
    }

    /**
     * Constructs a new DiscountException with the specified detail message.
     * @param message Message describing the exception
     */
    public DiscountException(InvoiceItem item, String message){
        super(message);
        problemItem = item;
    }
}
