import java.util.*;

/**
 * Creates an Invoice. The invoice is a collection of InvoiceItems,
 * and the Invoice object performs invoice functions on the group
 * of items.
 *
 * Author: Alex
 * Version: 3/16/14.
 */
public class Invoice {

    /*
    Instance fields
     */
    private List<InvoiceItem> invoiceItems = null;
    private double invoiceDiscount = 0.00;
    private double totalInvoiceValue = 0.00;
    private double totalItemDiscount = 0.00;
    private double totalDiscountAmount = 0.00;
    private double totalInvoiceNetDue = 0.00;

    /**
     * Constructs a new Invoice
     */
    public Invoice() {
        invoiceItems = new ArrayList<InvoiceItem>();
    }

    /**
     * Adds an InvoiceItem to the invoice.
     * @param item The item to be added.
     * @throws IllegalArgumentException Checks for null parameter.
     * @throws DiscountException Checks that a discounted item is not being added to a discounted invoice.
     */
    public void addInvoiceItem(InvoiceItem item) throws IllegalArgumentException, DiscountException  {
        if (item == null) {
            System.out.println("Item is null.");
            throw new IllegalArgumentException("Item is null.");
        }
        if (invoiceDiscount > 0.00 && item.getDiscount() > 0) {
            throw new DiscountException("Discounted item (" +
                    item.getItemDescription() + ") cannot be added to a " +
                    "discounted invoice.\n");
        }
        invoiceItems.add(item);
        System.out.println(item.getQuantity() + " " + item.getItemDescription() +
                " added to invoice");
    }

    /**
     * Removes and item from the invoice.
     * @param item InvoiceItem to be removed
     */
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

    /**
     * Checks for and reports problems with the invoice. If no problems are reported, the
     * invoice is considered processed.
     * @throws DiscountException
     */
    public void processInvoice() throws DiscountException {

        System.out.println("\nProcessing invoice...");
        if (invoiceItems.size() == 0) {
            System.out.println("Invoice has no items to process.");
        }
        else {
            if (invoiceDiscount > 0.00) {
                HashMap<String, Double> discountList = new HashMap<String, Double>();
                for (InvoiceItem item : invoiceItems) {
                    if (item.getDiscount() > 0) {
                        discountList.put(item.getItemDescription(), item.getDiscount());
                    }
                }
                if (discountList.size() > 0) {
                    System.out.println("Discounted items cannot be included on a " +
                            "discounted invoice.\nInvoice, discount: " +
                            invoiceDiscount + "\nDiscount details:");
                    for (Map.Entry<String, Double> item : discountList.entrySet()) {
                        System.out.println(item.getKey() + ", discount: " + item.getValue());
                    }
                    throw new DiscountException("Invoice and items cannot both be discounted.");
                }
            }
        }
        /*Just because it seems like calculating the invoice totals should be part of processing
        we do that here, although nothing is done with them.*/
        calculateInvoiceTotals();
        System.out.println("Invoice processed.");
    }

    /**
     * Prints an invoice.
     */
    public void printInvoice() {
        System.out.println("\nPrinting invoice...");
        for (InvoiceItem item : invoiceItems) {
            System.out.println("Item: \t\t" + item.getItemDescription());
            System.out.println("Quantity: \t" + item.getQuantity());
            System.out.println("Subtotal: \t" + item.getTotalValue());
            System.out.println("Discount: \t" + item.getTotalDiscount());
            System.out.println("Net Cost: \t" + item.getNetCost() + "\n");
        }
        /* the method doesn't require that the invoice have been processed before
        printing, so the totals are calculated here to be sure. Not production-quality
        programming here.*/
        calculateInvoiceTotals();
        System.out.println("Invoice Subtotal: \t" + totalInvoiceValue);
        System.out.println("Total Discount: \t" + totalDiscountAmount);
        System.out.println("Total Due: \t" + totalInvoiceNetDue + "\n");
    }

    /*
     * Does the calculations to total the invoice.
     */
    private void calculateInvoiceTotals() {

        for (InvoiceItem item : invoiceItems) {
            totalInvoiceValue += item.getTotalValue();
            totalItemDiscount += item.getTotalDiscount();
        }
        totalDiscountAmount = totalInvoiceValue * invoiceDiscount + totalItemDiscount;
        totalInvoiceNetDue = totalInvoiceValue - totalDiscountAmount;
    }
}