package edu.washington.ext;

/**
 * Class creates a Sales Associate
 * @author Alex Harris
 * @version February 27, 2014
 */
public class SalesAssociate extends StoreEmployee {

    private double commissionRate = 0;

    /**
     * Creates a Sales Associate
     * @param name Associate's name
     */
    public SalesAssociate(String name) {
        super(name);
    }

    /**
     * Set the Sales Associate's commission rate
     * @param rate Commission rate
     */
    public void setCommissionRate(double rate) {
        commissionRate = rate;
    }

    /**
     * Calculate the Sales Associate's pay
     * @return Pay amount
     */
    public double calculatePay() {
        return (super.calculatePay() + (getCurrentSales() * commissionRate));
    }

}
