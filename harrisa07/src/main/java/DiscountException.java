/**
 * Created by Alex on 3/16/14.
 */
public class DiscountException extends Exception {

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
