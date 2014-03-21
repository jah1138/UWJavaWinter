package edu.washington.ext;

import java.util.*;

/**
 * Creates an edu.washington.ext.Invoice. The invoice is a collection of InvoiceItems,
 * and the edu.washington.ext.Invoice object performs invoice functions on the group
 * of items.
 *
 * Author: Alex
 * Version: 3/16/14.
 */
public class Invoice {

    /**
     * Instance fields
     */
    private List<InvoiceItem> invoiceItems = null;
    private double invoiceDiscount = 0.00;
    private double totalInvoiceValue = 0.00;
    private double totalItemDiscount = 0.00;
    private double totalDiscountAmount = 0.00;
    private double totalInvoiceNetDue = 0.00;

    /**
     * Constructs a new edu.washington.ext.Invoice
     */
    public Invoice() {
        invoiceItems = new ArrayList<InvoiceItem>();
    }

    /**
     * Gets total invoice amount, before any discounts.
     * @return Total invoice amount.
     */
    public double getTotalInvoiceValue() {
        return totalInvoiceValue;
    }

    /**
     * Gets invoice amount due, after discounts.
     * @return edu.washington.ext.Invoice amount due.
     */
    public double getTotalInvoiceNetDue() {
        return totalInvoiceNetDue;
    }

    /**
     * Gets total dollar amount of discounts on invoice.
     * @return Total discount amount.
     */
    public double getTotalDiscountAmount() {
        return totalDiscountAmount;
    }

    /**
     * Adds an edu.washington.ext.InvoiceItem to the invoice.
     * @param item The item to be added.
     * @throws IllegalArgumentException Checks for null parameter.
     * @throws DiscountException Checks that a discounted item is not being added to a discounted invoice.
     */
    public void addInvoiceItem(InvoiceItem item) throws IllegalArgumentException, DiscountException  {
        if (item == null) {
            System.out.println("edu.washington.ext.Item is null.");
            throw new IllegalArgumentException("edu.washington.ext.Item is null.");
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
     * @param item edu.washington.ext.InvoiceItem to be removed
     */
    public void removeInvoiceItem(InvoiceItem item) {
        invoiceItems.remove(item);
        System.out.println(item + " removed from invoice");
    }

    /**
     * Sets the discount for the entire invoice.
     * @param invoiceDiscount The discount amount applied to the invoice.
     * @throws DiscountException
     */
    public void setInvoiceDiscount(double invoiceDiscount) throws DiscountException {
        if (invoiceDiscount < 0) {
            System.out.println("Discount cannot be negative.");
            throw new DiscountException("Discount cannot be negative.");
        }
        this.invoiceDiscount = invoiceDiscount;
        System.out.println("edu.washington.ext.Invoice discount set to " + invoiceDiscount);
    }

    /**
     * Gets the discount amount being applied to the invoice.
     * @return The invoice discount, decimal.
     */
    public double getInvoiceDiscount() {
        return invoiceDiscount;
    }

    /**
     * Checks the invoice for problems and prints it out.
     * @throws DiscountException
     */
    public void processInvoice() throws DiscountException {

        System.out.println("\nProcessing invoice...");
        if (invoiceItems.size() == 0) {
            System.out.println("edu.washington.ext.Invoice has no items to process.");
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
                            "discounted invoice.\nedu.washington.ext.Invoice, discount: " +
                            invoiceDiscount + "\nDiscount details:");
                    for (Map.Entry<String, Double> item : discountList.entrySet()) {
                        System.out.println(item.getKey() + ", discount: " + item.getValue());
                    }
                    throw new DiscountException("edu.washington.ext.Invoice and items cannot both be discounted.");
                }
            }
        }
        System.out.println("\nedu.washington.ext.Invoice processed.");
        calculateInvoiceTotals();
        printInvoice();
    }

    /**
     * Prints an invoice.
     */
    private void printInvoice() {
        System.out.println("\nPrinting invoice...");
        for (InvoiceItem item : invoiceItems) {
            System.out.println("edu.washington.ext.Item: \t\t" + item.getItemDescription());
            System.out.println("Quantity: \t" + item.getQuantity());
            System.out.printf("Subtotal:\t$%,.2f%n", item.getTotalValue() / 100);
            System.out.printf("Discount:\t$%,.2f%n", item.getTotalDiscount() / 100);
            System.out.printf("Net Cost:\t$%,.2f%n%n", item.getNetCost() / 100);
        }
        System.out.printf("edu.washington.ext.Invoice Subtotal:\t$%,.2f%n", totalInvoiceValue / 100);
        System.out.printf("Total Discount:\t$%,.2f%n", totalDiscountAmount / 100);
        System.out.printf("Total Due:\t$%,.2f%n%n", totalInvoiceNetDue / 100);
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