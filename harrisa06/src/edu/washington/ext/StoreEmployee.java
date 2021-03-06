package edu.washington.ext;

import edu.washington.ext.common.AbstractEmployee;
import edu.washington.ext.common.Employee;

/**
 * Creates a Store Employee.
 *
 * @author Alex Harris
 * @version February 27, 2014
 */
public class StoreEmployee extends AbstractEmployee {

//    private String name = null;
    private double currentHours = 0, hourlyRate = 0, currentSales = 0;

    /**
     * Default constructor.
     */
    public StoreEmployee() {
        this("New Employee");
    }

    /**
     * Creates an employee.
     * @param name Employee name
     */
    public StoreEmployee(String name) {
        super(name);
    }

    /**
     * Sets employee's current total sales amount
     * @param Sales Employee's sales
     */
    public void setCurrentSales(double sales) {
        currentSales = sales;
    }

    /**
     * Gets employee's current sales numbers.
     * @return Employee's sales
     */
    public double getCurrentSales() {
        return currentSales;
    }

    /**
     * Sets employee's hourly rate of pay.
     * @param rate Employee's hourly rate of pay
     */
    public void setHourlyRate(double rate) {
        hourlyRate = rate;
    }

    /**
     * Sets employee's total current hours worked.
     * @param hours Employee's current hours
     */
    public void setCurrentHours(double hours) {
        currentHours = hours;
    }

    /**
     * Calculates employee's pay.
     * The calculation is Hourly rate * Current hours worked.
     * @return Employee's pay
     */
    public double calculatePay() {
        return hourlyRate * currentHours;
    }

}