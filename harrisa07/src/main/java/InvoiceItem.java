/**
 * Created by Alex on 3/16/14.
 */
public final class InvoiceItem {

    private final Item item;
    private int quantity = 0;
    private double discount = 0.00;

    public InvoiceItem(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public String getItemDescription() {
        return item.getDescription();
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getTotalValue() {
        return item.getPrice() * quantity;
    }

    public double getTotalDiscount() {
        return getTotalValue() * discount;
    }

    public double getNetCost() {
        return getTotalValue() - getTotalDiscount();
    }






}
