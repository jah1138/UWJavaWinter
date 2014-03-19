import org.junit.Assert;
import org.junit.Test;

/**
 * Author: Alex Harris
 * Version: 3/16/14.
 */
public class InvoiceTest {

    /**
     * Initialization data for test items
     */
    Item keyboard = new Item("Keyboard", 2500, 01234);
    Item mouse = new Item("Mouse", 1700, 56789);
    Item monitor = new Item("Monitor", 17500, 13579);

    public InvoiceTest() {

    }

    /**
     * Test for setting an Invoice discount to a negative number.
     * @throws DiscountException
     */
    @Test (expected = DiscountException.class)
    public void testSetInvoiceDiscount02() throws DiscountException {

        Invoice invoice = new Invoice();
        invoice.setInvoiceDiscount(-0.10);
    }

    /**
     * Test for setting an InvoiceItem discount to a negative number.
     * @throws DiscountException
     */
    @Test (expected = DiscountException.class)
    public void testSetInvoiceItemDiscount() throws DiscountException {

        InvoiceItem invoiceItem = new InvoiceItem(keyboard, 5);
        invoiceItem.setDiscount(-0.05);
    }

    /**
     * Tests for passing a null item as a parameter to InvoiceItem.
     * @throws IllegalArgumentException
     */
    @Test (expected = IllegalArgumentException.class)
    public void testCreateInvoiceItem() throws IllegalArgumentException {

        Item nullItem = null;
        InvoiceItem invoiceItem = new InvoiceItem(nullItem, 3);
    }

    /**
     * Test for adding a null InvoiceItem to an invoice.
     * @throws IllegalArgumentException
     */
    @Test (expected = IllegalArgumentException.class)
    public void testAddInvoiceItem() throws IllegalArgumentException, DiscountException {

        Invoice invoice = new Invoice();
        InvoiceItem nullInvoiceItem = null;
        invoice.addInvoiceItem(nullInvoiceItem);
    }

//     @Test
//    public void testNewItem() throws DiscountException{
//         Item item = new Item("Geegaw", 1200, 32211);
//         Item item2 = new Item("Thing", 125, 11123);
//         InvoiceItem invItem = new InvoiceItem(item2, 1);
//         InvoiceItem invItem2 = new InvoiceItem(item, 12);
//
//         Invoice invoice = new Invoice();
//         invoice.addInvoiceItem(invItem);
//         invoice.addInvoiceItem(invItem2);
//         invoice.setInvoiceDiscount(0.10);
//         invoice.printInvoice();
//         invoice.processInvoice();
//     }

    /**
     * Processes the invoice and tests whether InvoiceItems and Invoice
     * both have discounts.
     * @throws DiscountException
     */
    @Test (expected = DiscountException.class)
    public void testProcessInvoice() throws DiscountException {

        InvoiceItem keyboardItem = new InvoiceItem(keyboard, 5);
        InvoiceItem mouseItem = new InvoiceItem(mouse, 5);
        InvoiceItem monitorItem = new InvoiceItem(monitor, 5);

        Invoice invoice = new Invoice();

        invoice.addInvoiceItem(keyboardItem);
        invoice.addInvoiceItem(mouseItem);
        invoice.addInvoiceItem(monitorItem);

        invoice.printInvoice();

        invoice.setInvoiceDiscount(0.10);
        keyboardItem.setDiscount(0.05);
        monitorItem.setDiscount(0.25);

        invoice.processInvoice();
    }
}