package edu.washington.ext;

import edu.washington.ext.common.CommissionedEmployee;
import edu.washington.ext.common.Employee;

import java.util.ArrayList;
import java.util.List;

/**
 * Creates a Store.
 *
 * @author Alex Harris
 * @version February 27, 2014.
 */
public final class Store {

    private int storeNumber = 0;
    private Manager manager = null;
    private List<StoreEmployee> employees = null;
    private PayrollRecord[] payroll = null;

    /**
     * Constructs a store with a given store number.
     * @param storeNumber The store's number
     */
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
            employees = new ArrayList<StoreEmployee>();
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
        manager.setMyStore(this);
    }

    /**
     * Gets a list of all current store employees.
     * @return an ArrayList of all employees.
     */
    public List<StoreEmployee> getEmployees() {
        if (employees == null) {
            employees = new ArrayList<StoreEmployee>();
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

    /**
     * Gets the current total sales of the store.
     * @return Store sales
     */
    public double getCurrentSales() {
        double totalSales = 0;
        for (StoreEmployee emp : employees) {
            totalSales += emp.getCurrentSales();
        }
        totalSales += manager.getCurrentSales();
        return totalSales; // sum of all employee sales
    }

    /* Payroll operations*/

    /**
     * Calculates the total commission to be paid out by the store.
     * @return Total store commission
     */
    public double getTotalCommissions() {
        double totalCommission = 0;
        for (StoreEmployee emp : employees) {
//            if (CommissionedEmployee.class.isAssignableFrom(emp.getClass())) {
            if (emp instanceof SalesAssociate) {
                SalesAssociate sa = (SalesAssociate)emp;
                totalCommission += sa.calculateCommission();
            }
        }
        totalCommission += manager.calculateCommission();
        return totalCommission;
    }

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

//    /**
//     * Prints out a copy of the store's current payroll records.
//     */
//    public void printPayroll() {
//        if (payroll != null) {
//            for (PayrollRecord pr : payroll) {
//                System.out.println(pr.getRecord());
//            }
//        }
//        else {
//            System.out.println("There are no payroll records");
//        }
//    }

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
