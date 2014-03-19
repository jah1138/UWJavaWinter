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
            throw new DiscountException("Discounted item (" +
                    item.getItemDescription() + ") cannot be added to a " +
                    "discounted invoice.\n");
        }
        System.out.println(item.getQuantity() + " " + item.getItemDescription() +
                " added to invoice");
    }

    public void removeInvoiceItem(InvoiceItem item) {
        invoiceItems.remove(item);
        System.out.println(item + " removed from invoice");
    }

    public void setInvoiceDiscount(double invoiceDiscount) throws DiscountException {
        if (invoiceDiscount < 0) {
            System.out.println("Discount cannot be negative.");
            throw new DiscountException("Discount cannot be negative.");
        }
        this.invoiceDiscount = invoiceDiscount;
        System.out.println("Invoice discount set to " + invoiceDiscount);
    }

    public double getInvoiceDiscount() {
        return invoiceDiscount;
    }

    public void processInvoice() throws DiscountException {
        System.out.println("Processing invoice...");
        if (invoiceItems.size() > 0) {
            HashMap<String, Double> discountList = new HashMap<String, Double>();
            for (InvoiceItem item : invoiceItems) {
                if (item.getDiscount() > 0) {
                    discountList.put(item.getItemDescription(), item.getDiscount());
                }
            }
            if (discountList.size() > 0) {
                System.out.println("Discounted items cannot be included on a " +
                        "discounted invoice.\nInvoice discount: " +
                        invoiceDiscount + "\nDiscounted items:");
                for (Map.Entry<String, Double> item : discountList.entrySet()) {
                    System.out.println(item.getKey() + ", discount: " + item.getValue());
                }
                throw new DiscountException("Invoice and items cannot both be discounted.");
            }
        }
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