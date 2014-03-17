package edu.washington.ext.common;

/**
 * Defines an employee; to be used as the base class for all employee types.
 *
 * @author Alex Harris
 * @version 3/8/2014
 */
public abstract class AbstractEmployee implements Employee {

    /**Name variable.*/
    private String name = null;

    public AbstractEmployee(String name) {
        this.name = name;
    }

    /**
     * Returns the employee's name.
     * @return Employee's name
     */
    public final String getName() {
        return name;
    }

    /**
     * Calculate employee's pay.
     * @return Employee's pay
     */
    public abstract double calculatePay() ;
}

