package edu.washington.ext;

/**
 * Creates a Payroll Record for an employee
 *
 * @author Alex Harris
 * @version February 27, 2014
 */
public class PayrollRecord {

    private String employeeName = "";
    private double currentPay = 0.0;

    /**
     * Creates a Payroll Record for an employee
     * @param employeeName Employee's name
     * @param currentPay Employee's current pay
     */
    public PayrollRecord(String employeeName, double currentPay) {
        this.employeeName = employeeName;
        this.currentPay = currentPay;
    }

    /**
     * Gets employee's current pay
     * @return Employee's current pay
     */
    public double getCurrentPay() {
        return currentPay;
    }

    /**
     * Gets employees name
     * @return Employee's name
     */
    public String getEmployeeName() {
        return employeeName;
    }

}
