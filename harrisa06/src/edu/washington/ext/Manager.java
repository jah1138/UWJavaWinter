package edu.washington.ext;

import edu.washington.ext.common.AbstractEmployee;
import edu.washington.ext.common.CommissionedEmployee;

/**
 * Creates a Store Manager.
 *
 * @author Alex Harris
 * @version February 27, 2014
 */
public final class Manager extends AbstractEmployee implements CommissionedEmployee {

    /**
     * Fields.
     */
    private String name = "";
    private double basePay = 0;
    private static double commissionRate = 0.005;
    private Store myStore = null;
    private double currentSales = 0;
    private double currentStoreSales = 0;


    /**
     * Default constructor.
     */
    public Manager() {
        this("New Manager");
    }

    /**
     * Constructor for a Manager.
     * @param name Manager's name
     */
    public Manager(String name) {
        super(name);
    }

    /**
     * Set the sales totals for the store manager.
     * @param sales Manager's total sales
     */
    public void setCurrentSales(double sales) {
        currentSales = sales;
    }

    /**
     * Gets the manager's current total sales.
     * @return Manager's sales.
     */
    public double getCurrentSales() {
        return currentSales;
    }

    /**
     * Set the total sales for the manager's store.
     * @param currentSales Current store sales
     */
    public void setCurrentStoreSales(double currentSales) {
        currentStoreSales = currentSales + myStore.getCurrentSales();
    }

    /**
     * Get current store sales.
     * @return Current store sales
     */
    public double getCurrentStoreSales() {
        return myStore.getCurrentSales();
    }
    /**
     *
     * Sets the commission rate which applies to all managers.
     * @param rate Commission rate
     */
    public static void setCommissionRate(double rate) {
        commissionRate = rate;
    }

    /**
     * Sets the manager's base salary.
     * @param basePay Manager's base salary.
     */
    public void setBasePay(final double basePay) {
        this.basePay = basePay;
    }

    /**
     * Calculates manager's pay.
     * The calculation is: Manager's base salary + (Store sales * Commission rate)
     * @return Manager's pay
     */
    public double calculatePay() {
        return basePay + (calculateCommission());
    }

    /**
     * Calculates the manager's commission.
     * Calculation is: Manager's Store's Sales * Commission Rate
     * @return Commission
     */
    public double calculateCommission() {
        return getCurrentStoreSales() * commissionRate;
    }

    /**
     * Associates the manager with the store he manages.
     * @param store The store managed by this manager.
     */
    public void setMyStore(Store store) {
        myStore = store;
    }

}
