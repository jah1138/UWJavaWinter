import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex on 3/16/14.
 */
public class Invoice {

    private List<InvoiceItem> invoiceItems = null;
    private double invoiceDiscount = 0.0;

    public Invoice() {
        invoiceItems = new ArrayList<InvoiceItem>();
    }

    public void addInvoiceItem(InvoiceItem item) throws DiscountException {
        try {
            invoiceItems.add(item);
        }
        catch (IllegalArgumentException e) {
            System.out.println("Item " + e + " does not exist.");
        }
        if (invoiceDiscount > 0.00 && item.getDiscount() > 0) {
            throw new DiscountException(item, "Discounted item " +
                    item + " is not allowed on a discounted invoice.");
        }
    }

    public void removeInvoiceItem(InvoiceItem item) {

    }

    public void setInvoiceDiscount(double invoiceDiscount) throws DiscountException  {
        if (invoiceDiscount < 0) {
            throw new DiscountException("Discount cannot be negative.");
        }
        this.invoiceDiscount = invoiceDiscount;
    }

    public double getInvoiceDiscount() {

        return invoiceDiscount;
    }

    public void processInvoice() {

    }

    public void printInvoice() {

    }
}