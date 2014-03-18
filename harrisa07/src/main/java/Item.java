/**
 * Created by Alex on 3/16/14.
 */
public final class Item {

    /**
     * Instance fields
     */
    private String description = null;
    private double price = 0.00;
    private int sku = 0;

    /**
     * Creates an Item object with generic values, which can be edited later.
     */
    public Item() {
        new Item("", 0.00, 0);
    }

    /**
     * Creates an Item object with three values.
     * @param description Item description
     * @param price Item price, in cents
     * @param sku Item SKU
     */
    public Item(String description, double price, int sku) {
        this.description = description;
        this.price = price;
        this.sku = sku;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getSku() {
        return sku;
    }

    public void setSku(int sku) {
        this.sku = sku;
    }
}
