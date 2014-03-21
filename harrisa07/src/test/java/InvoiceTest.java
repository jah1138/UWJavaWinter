import edu.washington.ext.DiscountException;
import edu.washington.ext.Invoice;
import edu.washington.ext.InvoiceItem;
import edu.washington.ext.Item;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Class for testing the edu.washington.ext.Invoice class features and function.
 * Author: Alex Harris
 * Version: 3/16/14.
 */
public class InvoiceTest {

    /**
     * Initialization data for test items
     */
    @SuppressWarnings("OctalInteger")
    Item keyboard = new Item("Keyboard", 2500, 01234);
    Item mouse = new Item("Mouse", 1700, 56789);
    Item monitor = new Item("Monitor", 17500, 13579);

    public InvoiceTest() {

    }

    /**
     * Tests for setting an edu.washington.ext.Invoice discount to a negative number.
     * @throws DiscountException
     */
    @Test (expected = DiscountException.class)
    public void testSetInvoiceDiscount02() throws DiscountException {

        Invoice invoice = new Invoice();
        invoice.setInvoiceDiscount(-0.10);
    }

    /**
     * Tests for setting an edu.washington.ext.InvoiceItem discount to a negative number.
     * @throws DiscountException
     */
    @Test (expected = DiscountException.class)
    public void testSetInvoiceItemDiscount() throws DiscountException {

        InvoiceItem invoiceItem = new InvoiceItem(keyboard, 5);
        invoiceItem.setDiscount(-0.05);
    }

    /**
     * Tests for passing a null item as a parameter to edu.washington.ext.InvoiceItem.
     * @throws IllegalArgumentException
     */
    @Test (expected = IllegalArgumentException.class)
    public void testCreateInvoiceItem() throws IllegalArgumentException {

        Item nullItem = null;
        InvoiceItem invoiceItem = new InvoiceItem(nullItem, 3);
    }

    /**
     * Tests for adding a null edu.washington.ext.InvoiceItem to an invoice.
     * @throws IllegalArgumentException
     */
    @Test (expected = IllegalArgumentException.class)
    public void testAddInvoiceItem() throws IllegalArgumentException, DiscountException {

        Invoice invoice = new Invoice();
        InvoiceItem nullInvoiceItem = null;
        invoice.addInvoiceItem(nullInvoiceItem);
    }

    /**
     * Tests the check for conflicting discounts when processing an invoice.
     * @throws edu.washington.ext.DiscountException
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

        invoice.setInvoiceDiscount(0.10);
        keyboardItem.setDiscount(0.05);
        monitorItem.setDiscount(0.25);

        invoice.processInvoice();
    }

    /**
     * Tests printing of good invoice
     * @throws DiscountException
     */
    @Test
    public void testProcessInvoice02() throws DiscountException {

        InvoiceItem keyboardItem = new InvoiceItem(keyboard, 5);
        InvoiceItem mouseItem = new InvoiceItem(mouse, 5);
        InvoiceItem monitorItem = new InvoiceItem(monitor, 5);

        Invoice invoice = new Invoice();

        invoice.addInvoiceItem(keyboardItem);
        invoice.addInvoiceItem(mouseItem);
        invoice.addInvoiceItem(monitorItem);

        keyboardItem.setDiscount(0.05);
        monitorItem.setDiscount(0.25);

        invoice.processInvoice();
        assertEquals(108500, invoice.getTotalInvoiceValue(), .005);
        assertEquals(22500, invoice.getTotalDiscountAmount(), .005);
        assertEquals(86000, invoice.getTotalInvoiceNetDue(), .005);
    }
}