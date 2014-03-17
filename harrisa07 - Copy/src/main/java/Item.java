/**
 * Created by Alex on 3/16/14.
 */
public final class Item {

    /**
     * Instance fields
     */
    private String description = null;
    private double price = 0;
    private int sku = 0;

    /**
     * Creates an Item object with generic values, which can be edited later.
     */
    public Item() {
        new Item("", 0.00, 0);
    }

    /**
     * Creates an Item object with three parameters.
     * @param description Item description
     * @param price Item price, in cents
     * @param sku Item SKU
     */
    public Item(String description, double price, int sku) {
        this.description = description;
        this.price = price;
        this.sku = sku;

    }
}