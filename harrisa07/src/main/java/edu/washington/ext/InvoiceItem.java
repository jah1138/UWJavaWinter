package edu.washington.ext;

/**
 * Defines an edu.washington.ext.InvoiceItem object, which sets a quantity of Items to purchase, as well as
 * a discount to be applied to the edu.washington.ext.InvoiceItem.
 * Author: Alex Harris
 * Version: 3/16/14.
 */
public final class InvoiceItem {

    /**
     *     Instance fields.
     */
    private final Item item;
    private int quantity = 0;
    private double discount = 0.00;

    /**
     * Constructs an edu.washington.ext.InvoiceItem.
     * @param item edu.washington.ext.Item that is being purchased.
     * @param quantity Quantity of the item being purchased.
     * @throws IllegalArgumentException If a null edu.washington.ext.Item is passed to the constructor.
     */
    public InvoiceItem(Item item, int quantity) throws IllegalArgumentException {
        if (item == null) {
            System.out.println("edu.washington.ext.Item is null.");
            throw new IllegalArgumentException("edu.washington.ext.Item is null.");
        }
        this.item = item;
        this.quantity = quantity;
    }

    /**
     * Gets the item description.
     * @return edu.washington.ext.Item description
     */
    public String getItemDescription() {
        return item.getDescription();
    }

    /**
     * Gets the quantity being purchased.
     * @return Quantity of the item being purchased.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the quantity of the item that is being purchased.
     * @param quantity Quantity of the item being purchased.
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
}

    /**
     * Gets the discount applied to this specific edu.washington.ext.Item purchase.
     * @return Discount applied to this edu.washington.ext.InvoiceItem.
     */
    public double getDiscount() {
        return discount;
    }

    /**
     * Sets the discount for this edu.washington.ext.InvoiceItem.
     * @param discount The discount percentage, as a decimal
     * @throws DiscountException Checks for a negative discount.
     */
    public void setDiscount(double discount) throws DiscountException {
        if (discount < 0) {
            System.out.println("Discount cannot be negative.\n");
            throw new DiscountException("Discount cannot be negative.");
        }
        this.discount = discount;
        System.out.println(item.getDescription() + " discount set to " + discount);
    }

    /**
     * Gets the total value of the purchase, which is the original price x quantity
     * being purchased.
     * @return Total value of the purchase.
     */
    public double getTotalValue() {
        return item.getPrice() * quantity;
    }

    /**
     * Gets the total discount that will be applied to this purchased item, which is
     * the Total Value time the Discount
     * @return Total amount of discount.
     */
    public double getTotalDiscount() {
        return getTotalValue() * discount;
    }

    /**
     * Gets the net cost of this item purchase, which is the Total Cost less the
     * discounted amount.
     * @return Net cost of purchase.
     */
    public double getNetCost() {
        return getTotalValue() - getTotalDiscount();
    }

}
