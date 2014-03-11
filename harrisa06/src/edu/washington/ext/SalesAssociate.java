package edu.washington.ext;

import edu.washington.ext.common.CommissionedEmployee;

/**
 * Class creates a Sales Associate
 *
 * @author Alex Harris
 * @version February 27, 2014
 */
public final class SalesAssociate extends StoreEmployee implements CommissionedEmployee {

    private double commissionRate = 0;

    /**
     * Default constructor.
     */
    public SalesAssociate() {
        this("New Sales Associate");
    }

    /**
     * Creates a Sales Associate.
     * @param name Associate's name.
     */
    public SalesAssociate(String name) {
        super(name);
    }

    /**
     * Sets the Sales Associate's commission rate.
     * @param rate Commission rate.
     */
    public void setCommissionRate(double rate) {
        commissionRate = rate;
    }

    /**
     * Gets the associate's total commission
     * @return Total commission
     */
    public double calculateCommission() {
        return getCurrentSales() * commissionRate;
    }

    /**
     * Calculates the Sales Associate's pay.
     * The calculation is (Hourly rate * Hours worked) + (Current sales * Commission rate).
     * @return Pay amount.
     */
    public double calculatePay() {
        return (super.calculatePay() + calculateCommission());
    }

}
