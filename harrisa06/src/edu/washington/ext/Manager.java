package edu.washington.ext;

import edu.washington.ext.common.AbstractEmployee;
import edu.washington.ext.common.CommissionedEmployee;

/**
 * Creates a Store Manager.
 *
 * @author Alex Harris
 * @version February 27, 2014
 */
public class Manager extends AbstractEmployee implements CommissionedEmployee {

    /**
     * Fields.
     */
    private String name = "";
    private double basePay = 0;
    private static double commissionRate = 0.005;
    private Store myStore = null;

    /**
     * Constructor for a Manager.
     * @param name Manager's name
     */
    public Manager(final String name) {
        this.name = name;
    }

    /**
     * Sets the commission rate which applies to all managers.
     * @param rate Commission rate
     */
    public static void setBonusRate(final double rate) {
        commissionRate = rate;
    }

    /**
     * Get current store sales.
     * @return Current store sales
     */
    public final double getCurrentStoreSales() {
        return myStore.getCurrentSales();
    }

    /**
     * Sets the manager's base salary.
     * @param basePay Manager's base salary.
     */
    public final void setBasePay(final double basePay) {
        this.basePay = basePay;
    }

    /**
     * Calculates manager's pay.
     * The calculation is: Manager's base salary + (Store sales * Commission rate)
     * @return Manager's pay
     */
    public final double calculatePay() {
        return basePay + (calculateCommission());
    }

    /**
     * Calculates the manager's commission.
     * Calculation is: Manager's Store's Sales * Commission Rate
     * @return Commission
     */
    public final double calculateCommission() {
        return getCurrentStoreSales() * commissionRate;
    }

    /**
     * Associates the manager with the store he manages.
     * @param store The store managed by this manager.
     */
    public final void setMyStore(Store store) {
        myStore = store;
    }

}
