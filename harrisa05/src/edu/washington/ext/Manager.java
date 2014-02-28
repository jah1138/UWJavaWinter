package edu.washington.ext;

/**
 * Creates a Store Manager.
 * @author Alex Harris
 * @version February 27, 2014
 */
public class Manager implements Employee {

    private String name = "";
    private double basePay = 0, currentStoreSales = 0, currentSales = 0;
    static double bonusRate = 0.005;

    /**
     * Creates a Manager
     * @param name Manager's name
     */
    public Manager(String name) {
        this.name = name;
    }

    /**
     * Sets the bonus rate for all managers.
     * @param rate Bonus rate
     */
    public static void setBonusRate(double rate) {
        bonusRate = rate;
    }

    /**
     * Set manager's current sales
     * @param sales Manager's sales
     */
    public void setCurrentSales(double sales) {
        currentSales = sales;
    }

    /**
     * Gets manager's current sales
     * @return Manager's sales
     */
    public double getCurrentSales() {
        return currentSales;
    }

    /**
     * Sets manager's base pay
     * @param basePay Manager's base pay
     */
    public void setBasePay(double basePay) {
        this.basePay = basePay;
    }

    /**
     * Sets the manager's current store sales
     * @param currentSales Current store sales
     */
    public void setCurrentStoreSales(double currentSales) {
        currentStoreSales = currentSales;
    }

    /*
     * I added this method so the store could access the store's sales.
     * Seems weird that this number belongs to the manager and not the store.
     */
    /**
     * Gets the current sales for the Manager's store
     * @return Current store sales
     */
    public double getCurrentStoreSales() {
        return currentStoreSales;
    }

    /**
     * Gets Manager's name
     * @return Manager's name
     */
    public String getName() {
        return name;
    }

    /**
     * Calculates manager's pay
     * @return Manager's pay
     */
    public double calculatePay() {
        return basePay + (currentStoreSales * bonusRate);
    }

}
