package edu.washington.ext;

/**
 * Creates a Payroll Record for an employee.
 *
 * @author Alex Harris
 * @version February 27, 2014
 */
public class PayrollRecord {

    private String employeeName = "";
    private double currentPay = 0.0;

    /**
     * Creates a Payroll Record for an employee
     * @param employee Employee's name
     * @param pay Employee's current pay
     */
    public PayrollRecord(String employee, double pay) {
        employeeName = employee;
        currentPay = pay;
    }

    /**
     * Gets the employee's current pay from the payroll record.
     * @return Employee's current pay.
     */
    public double getCurrentPay() {
        return currentPay;
    }

    /**
     * Gets rhe employee's name from the payroll record.
     * @return Employee's name.
     */
    public String getEmployeeName() {
        return employeeName;
    }

    /**
     * Gets the employee's complete payroll record data.
     * @return Employee's name and payroll amount.
     */
    public String getRecord() {
        return "Employee name: \t" + employeeName + "\n" +
                "Employee pay:\t$" + String.format("%.2f",currentPay);
    }

}
