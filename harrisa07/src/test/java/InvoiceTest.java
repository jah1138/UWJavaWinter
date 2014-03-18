/**
 * Created by Alex on 3/16/14.
 */
public class InvoiceTest {

    /**
     * Initialization data for test items
     */
    Item keyboard = new Item("Keyboard", 2500, 01234);
    Item mouse = new Item("Mouse", 1700, 56789);
    Item monitor = new Item("Monitor", 17500, 13579);

//    final String ITEM_ONE_DESCRIPTION = "Keyboard";
//    final String ITEM_TWO_DESCRIPTION = "Mouse";
//    final String ITEM_THREE_DESCRIPTION = "Monitor";
//    final double ITEM_ONE_PRICE = 2500;
//    final double ITEM_TWO_PRICE = 1700;
//    final double ITEM_THREE_PRICE = 17500;
//    final int ITEM_ONE_SKU = 01234;
//    final int ITEM_TWO_SKU = 56789;
//    final int ITEM_THREE_SKU = 13579;

//    Item keyboard = new Item(ITEM_ONE_DESCRIPTION, ITEM_ONE_PRICE, ITEM_ONE_SKU);
//    Item mouse = new Item(ITEM_TWO_DESCRIPTION, ITEM_TWO_PRICE, ITEM_TWO_SKU);
//    Item monitor = new Item(ITEM_THREE_DESCRIPTION, ITEM_THREE_PRICE, ITEM_THREE_SKU);

    public InvoiceTest() {

    }

    /**
     * Tests
     */
    public void testDiscountExceptionOne() {

        InvoiceItem InvItemOne = new InvoiceItem(keyboard, 5);
        InvoiceItem InvItemTwo = new InvoiceItem(mouse, 5);
        InvoiceItem InvItemThree = new InvoiceItem(monitor, 5);

        Invoice invoice = new Invoice();
        invoice.setInvoiceDiscount(0.10);
//        invoice.addInvoiceItem(InvItemOne);

    }

}