package edu.washington.ext;

/**
 * Class creates a Sales Associate
 *
 * @author Alex Harris
 * @version February 27, 2014
 */
public class SalesAssociate extends StoreEmployee {

    private double commissionRate = 0;

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
     * Calculates the Sales Associate's pay.
     * The calculation is (Hourly rate * Hours worked) + (Current sales * Commission rate).
     * @return Pay amount.
     */
    public double calculatePay() {
        return (super.calculatePay() + (getCurrentSales() * commissionRate));
    }

}
