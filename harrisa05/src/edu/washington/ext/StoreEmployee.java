package edu.washington.ext;

/**
 * Creates a Store Employee.
 * @author Alex Harris
 * @version February 27, 2014
 */
public class StoreEmployee implements Employee {

    private String name = null;
    private double currentHours = 0, hourlyRate = 0, currentSales = 0;

    /**
     * Creates an employee
     * @param name Employee name
     */
    public StoreEmployee(String name) {
        this.name = name;
    }

    /**
     * Sets employee's current sales
     * @param Sales Employee's sales
     */
    public void setCurrentSales(double Sales) {
        currentSales = Sales;
    }

    /**
     * Gets employee's current sales numbers
     * @return Employee's sales
     */
    public double getCurrentSales() {
        return currentSales;
    }

    /**
     * Set's employee's hourly rate of pay
     * @param rate Employee's hourly rate of pay
     */
    public void setHourlyRate(double rate) {
        hourlyRate = rate;
    }

    /**
     * Set employee's current hours
     * @param hours Employee's current hours
     */
    public void setCurrentHours(double hours) {
        currentHours = hours;
    }

    /**
     * Gets employee's name
     * @return Employee's name
     */
    public String getName() {
        return name;
    }

    /**
     * Calculates employee's pay
     * @return Employee's pay
     */
    public double calculatePay() {
        return hourlyRate * currentHours;
    }

}