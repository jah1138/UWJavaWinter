package edu.washington.ext;

import java.util.ArrayList;
import java.util.List;

/**
 * Creates a Store
 *
 * @author Alex Harris
 * @version February 27, 2014.
 */
public class Store {

    private int storeNumber = 0;
    private Manager manager = null;
    private List<Employee> employees = null;
    private PayrollRecord[] payroll = null;

    public Store(int storeNumber) {
        this.storeNumber = storeNumber;
    }

    public int getStoreNumber() {
        return storeNumber;
    }

    /* Is the store's currentSales the same thing as the Manager's
     * currentStoreSales? My code assumes so.
     */
    /**
     * Gets the current store sales from the Manager.
     * @return current store sales
     */
    public double getCurrentSales() {
        return manager.getCurrentStoreSales();
    }

    public void addEmployee(StoreEmployee employee) {
        if (employees == null) {
            employees = new ArrayList<Employee>();
        }
        else if (employees.contains(employee)) {
            System.err.println("This employee is already assigned to the store");
            return;
        }
        employees.add(employee);
    }

    public void setManager(Manager manager) {
        this.manager = manager;
        if (employees == null) {
            employees = new ArrayList<Employee>();
        }
        else if (employees.contains(manager)) {
            System.err.println("This manager is already assigned to the store");
            return;
        }
        else {
            for (Employee emp : employees) {
                if (emp instanceof Manager) {
                    employees.remove(emp);
                }
            }
        }
        employees.add(manager);
    }

    public List<Employee> getEmployees() {
        if (employees == null) {
            employees = new ArrayList<Employee>();
        }
        return employees;
    }

    public void printEmployees() {
        if (employees != null) {
            for (Employee emp : employees) {
                System.out.println(emp.getClass().getSimpleName() +
                        "\t" + emp.getName());
            }
        }
        else {
            System.out.println("No employees are currently on record");
        }
    }

    /* Payroll operations*/

    public PayrollRecord[] processPayroll() {
        payroll = new PayrollRecord[employees.size()];
        int i = 0;
        for (Employee emp : employees) {
            payroll[i] = new PayrollRecord(emp.getName(), emp.calculatePay());
            i++;
        }
        return payroll;
    }

    public void printPayroll() {
        if (payroll != null) {
            for (PayrollRecord pr : payroll) {
                System.out.println(pr.getRecord());
            }
        }
        else {
            System.out.println("There are no payroll records");
        }
    }

    public PayrollRecord[] getPayroll() {
        if (payroll == null) {
            processPayroll();
        }
        return payroll;
    }

}
