import java.util.*;

/**
 * Created by Alex on 3/16/14.
 */
public class Invoice {

    private List<InvoiceItem> invoiceItems = null;
    private double invoiceDiscount = 0.00;

    private double totalInvoiceValue = 0.00;
    private double totalDiscountAmount = 0.00;
    private double totalInvoiceNetDue = 0.00;

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
            throw new DiscountException(item, "Discounted item (" +
                    item + ") is not allowed on a discounted invoice.");
        }
        System.out.println(item + " added to invoice.");
    }

    public void removeInvoiceItem(InvoiceItem item) {
        invoiceItems.remove(item);
        System.out.println(item + " removed from invoice.");
    }

    public void setInvoiceDiscount(double invoiceDiscount) throws DiscountException {
        if (invoiceDiscount < 0) {
            throw new DiscountException("Discount cannot be negative.");
        }
        if (invoiceItems.size() > 0) {
            HashMap<String, Double> discountList = new HashMap<String, Double>();
            for (InvoiceItem item : invoiceItems) {
                if (item.getDiscount() > 0) {
                    discountList.put(item.getItemDescription(), item.getDiscount());
                }
            }
            if (discountList.size() > 0) {
                System.out.println("Discounted items are included in this invoice:\n");
                for (Map.Entry<String, Double> item : discountList.entrySet()) {
                    System.out.println("Item: " + item.getKey() + " Discount: " + item.getValue());
                }
                throw new DiscountException("Invoice and items cannot both be discounted.");
            }
        }
        this.invoiceDiscount = invoiceDiscount;
    }

    public double getInvoiceDiscount() {
        return invoiceDiscount;
    }

    public void processInvoice() {
        System.out.println("#\tItem");
        for (InvoiceItem item : invoiceItems) {
            totalInvoiceValue += item.getTotalValue();
            totalDiscountAmount += item.getTotalDiscount();
        }
        totalInvoiceNetDue = totalInvoiceValue * invoiceDiscount - totalDiscountAmount;
    }

    public void printInvoice() {
        System.out.println("Invoice Summary");
        for (InvoiceItem item : invoiceItems) {
            System.out.println("Item: \t\t" + item.getItemDescription());
            System.out.println("Quantity: \t" + item.getQuantity());
            System.out.println("Subtotal: \t" + item.getTotalValue());
            System.out.println("Item Discount: \t" + item.getTotalDiscount());
            System.out.println("Net Cost: \t" + item.getNetCost() + "\n");
        }
        System.out.print("Subtotal: \t" + totalInvoiceValue);
        System.out.println("Discount: \t" + totalDiscountAmount);
        System.out.println("Total Due: \t" + totalInvoiceNetDue + "\n");
    }
}