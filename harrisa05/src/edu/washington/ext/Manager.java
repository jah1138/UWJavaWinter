package edu.washington.ext;

/**
 * Creates a Store Manager.
 *
 * @author Alex Harris
 * @version February 27, 2014
 */
public class Manager implements Employee {

    private String name = "";
    private double basePay = 0, currentStoreSales = 0, currentSales = 0;
    static double bonusRate = 0.005;

    /**
     * Creates a Manager.
     * @param name Manager's name
     */
    public Manager(String name) {
        this.name = name;
    }

    /**
     * Sets the bonus rate which applies to all managers.
     * @param rate Bonus rate
     */
    public static void setBonusRate(double rate) {
        bonusRate = rate;
    }

    /**
     * Sets manager's current total individual sales amount.
     * @param sales Manager's current individual sales.
     */
    public void setCurrentSales(double sales) {
        currentSales = sales;
    }

    /**
     * Gets manager's current total individual sales amount.
     * @return Manager's current individual sales.
     */
    public double getCurrentSales() {
        return currentSales;
    }

    /**
     * Sets the manager's base salary.
     * @param basePay Manager's base salary.
     */
    public void setBasePay(double basePay) {
        this.basePay = basePay;
    }

    /**
     * Sets the current total sales for the manager's store.
     * @param currentSales Current store sales.
     */
    public void setCurrentStoreSales(double currentSales) {
        currentStoreSales = currentSales;
    }

    /*
     * I added this method so the store could access the store's sales.
     * Seems weird that this number belongs to the manager and not the store.
     */
    /**
     * Gets the current total sales for the manager's store.
     * @return Current store sales.
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
     * Calculates manager's pay.
     * The caluculation is: Manager's base salary + (Store sales * Commission rate)
     * @return Manager's pay
     */
    public double calculatePay() {
        return basePay + (currentStoreSales * bonusRate);
    }

}
