/**
 * Created by Alex on 3/16/14.
 */
public final class InvoiceItem {

    private final Item item;
    private int quantity = 0;
    private double discount = 0.00;

    public InvoiceItem(Item item, int quantity) throws IllegalArgumentException {
        if (item == null) {
            System.out.println("Item is null.");
            throw new IllegalArgumentException("Item is null.");
        }
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

    public void setDiscount(double discount) throws DiscountException {
        if (discount < 0) {
            System.out.println("Discount cannot be negative.\n");
            throw new DiscountException("Discount cannot be negative.");
        }
        this.discount = discount;
        System.out.println(item.getDescription() + " discount set to " + discount);
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
