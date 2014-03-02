package edu.washington.ext;

/**
 * A base employee type. The user of this interface has control over the
 * specialized forms of employee that are needed in any given implementation.
 *
 * @author Alex Harris
 * @version February 28, 2014
 */
public interface Employee {

    /**
     * Returns the employee's name
     * @return Employee's name
     */
    public String getName();

    /**
     * Gets the employee's pay
     * @return Employee's pay.
     */
    public double calculatePay();

}
