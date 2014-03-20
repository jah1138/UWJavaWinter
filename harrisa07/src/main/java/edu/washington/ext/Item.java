package edu.washington.ext;

/**
 * Defines an item for sale. This can be used to create an inventory for a shop.
 * edu.washington.ext.Item is used when defining an edu.washington.ext.InvoiceItem, which can be collected in an edu.washington.ext.Invoice.
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
     * Creates an edu.washington.ext.Item object with generic values, which can be edited later.
     */
    public Item() {
        new Item("", 0.00, 0);
    }

    /**
     * Creates an edu.washington.ext.Item object with three values.
     * @param description edu.washington.ext.Item description
     * @param price edu.washington.ext.Item price, in cents
     * @param sku edu.washington.ext.Item SKU
     */
    public Item(String description, double price, int sku) {
        this.description = description;
        this.price = price;
        this.sku = sku;
    }

    /**
     * Gets the item description.
     * @return edu.washington.ext.Item description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the item description.
     * @param description edu.washington.ext.Item description.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the item price.
     * @return edu.washington.ext.Item price.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the item price.
     * @param price edu.washington.ext.Item price, in cents.
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Gets the item SKU.
     * @return edu.washington.ext.Item SKU.
     */
    public int getSku() {
        return sku;
    }

    /**
     * Sets the item SKU.
     * @param sku edu.washington.ext.Item SKU.
     */
    public void setSku(int sku) {
        this.sku = sku;
    }
}
