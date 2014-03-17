/**
 * Created by Alex on 3/16/14.
 */
public class InvoiceItem {

    private Item item = null;
    private int quantity = 0;

    public InvoiceItem(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }
}
