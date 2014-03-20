/**
 * Defines an item for sale. This can be used to create an inventory for a shop.
 * Item is used when defining an InvoiceItem, which can be collected in an Invoice.
 * Author: Alex
 * Version: 3/16/14.
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

    /**
     * Gets the item description.
     * @return Item description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the item description.
     * @param description Item description.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the item price.
     * @return Item price.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the item price.
     * @param price Item price, in cents.
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Gets the item SKU.
     * @return Item SKU.
     */
    public int getSku() {
        return sku;
    }

    /**
     * Sets the item SKU.
     * @param sku Item SKU.
     */
    public void setSku(int sku) {
        this.sku = sku;
    }
}
