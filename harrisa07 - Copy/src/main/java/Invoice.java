import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex on 3/16/14.
 */
public class Invoice {

    private List<InvoiceItem> invoiceItems = null;
    private double discount = 0.0;

    public Invoice() {
        invoiceItems = new ArrayList<InvoiceItem>();

    }

    public void addInvoiceItem(InvoiceItem item){

    }

    public void removeInvoiceItem(InvoiceItem item) {

    }

    public void setDiscount(double discount) throws DiscountException  {
        if (discount < 0) {
            throw new DiscountException("Discount cannot be negative.");
        }
        this.discount = discount;
    }

    public double getDiscount() {

        return discount;
    }

    public void processInvoice() {

    }

    public void printInvoice() {

    }
}