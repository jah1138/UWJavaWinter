package edu.washington.ext;

import edu.washington.ext.common.Employee;

import java.util.ArrayList;
import java.util.List;

/**
 * Creates a Store.
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

    /**
     * Gets the store's identification number.
     * @return Store number
     */
    public int getStoreNumber() {
        return storeNumber;
    }

    /**
     * Adds a new employee to the store's staff.
     * @param employee The Employee being added to the staff.
     */
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

    /**
     * Names the Manager for the store. A store can have only one manager, so when a
     * manager is set using this method, any existing manager will be replaced.
     * @param manager The manager of the store.
     */
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
        manager.setMyStore(this);
    }

    /**
     * Gets a list of all current store employees, of all types.
     * @return an ArrayList of all employees.
     */
    public List<Employee> getEmployees() {
        if (employees == null) {
            employees = new ArrayList<Employee>();
        }
        return employees;
    }

    /**
     * Prints a list of all current store employees and their role.
     */
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

    public double getCurrentSales() {
        return 0; // sum of all employee sales
    }

    /* Payroll operations*/

    /**
     * Calculates current payroll and creates a payroll record for each of the
     * store employees.
     * @return An array of payroll records.
     */
    public PayrollRecord[] processPayroll() {
        payroll = new PayrollRecord[employees.size()];
        int i = 0;
        for (Employee emp : employees) {
            payroll[i] = new PayrollRecord(emp.getName(), emp.calculatePay());
            i++;
        }
        return payroll;
    }

    /**
     * Prints out a copy of the store's current payroll records.
     */
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

    /**
     * Returns any existing payroll records.
     *
     * This method does not process payroll, so the records it returns may not be current.
     *
     * If no payroll records exist, it will write a message to System.err and return null.
     * @return An array of payroll records.
     */
    public PayrollRecord[] getPayroll() {
        if (payroll == null) {
            System.err.println("Payroll has not been processed.");
            return null;
        }
        return payroll;
    }

}
