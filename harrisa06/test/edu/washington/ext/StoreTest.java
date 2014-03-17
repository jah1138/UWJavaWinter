package edu.washington.ext;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit test for Store and associated class functions
 *
 * @author Alex Harris
 * @version February 28, 2014
 */
public class StoreTest {

    /**
     * Constants for checking equality
     */
    final double MANAGER_PAY = 4502.50;
    final double OFFICE_EMP_PAY = 1680.00;
    final double ASS0CIATE01_PAY = 2025.00;
    final double ASSOCIATE02_PAY = 2920.00;
    final double ASSOCIATE03_PAY = 3750.00;
    final double STORE_CURRENT_SALES = 100500.00;
    final double STORE_COMMISSIONS = 2752.50;

    /**
     * Object declarations
     */
    private Store testStore;
    private Manager manager;
    private StoreEmployee officeEmp;
    private SalesAssociate salesAssociate01;
    private SalesAssociate salesAssociate02;
    private SalesAssociate salesAssociate03;

    @Before
    public void setUp() {

        /**
         * Set up the testing scenario
         * */
        testStore = new Store(1);

        testStore.setManager(manager = new Manager("Joe Manager"));
        testStore.addEmployee(officeEmp = new StoreEmployee("Janet OfficeEmployee"));
        testStore.addEmployee(salesAssociate01 = new SalesAssociate("Alan Associate01"));
        testStore.addEmployee(salesAssociate02 = new SalesAssociate("Bob Associate02"));
        testStore.addEmployee(salesAssociate03 = new SalesAssociate("Carol Associate03"));

        manager.setBasePay(4000);
        manager.setCurrentSales(10000);
        Manager.setCommissionRate(.005);

        officeEmp.setHourlyRate(10.50);
        officeEmp.setCurrentHours(160);
        officeEmp.setCurrentSales(500.00);

        salesAssociate01.setHourlyRate(12.50);
        salesAssociate01.setCurrentHours(138);
        salesAssociate01.setCommissionRate(.02);
        salesAssociate01.setCurrentSales(15000);

        salesAssociate02.setHourlyRate(14.50);
        salesAssociate02.setCurrentHours(160);
        salesAssociate02.setCommissionRate(.02);
        salesAssociate02.setCurrentSales(30000);

        salesAssociate03.setHourlyRate(15.00);
        salesAssociate03.setCurrentHours(160);
        salesAssociate03.setCommissionRate(.03);
        salesAssociate03.setCurrentSales(45000);
    }

    /*
     * Test the processPayroll method.
     */
    @Test
    public void testProcessPayroll() {
        testStore.processPayroll();
        assertNotNull(testStore.getPayroll());
        assertNotNull(testStore.getEmployees());
        assertEquals(testStore.getPayroll().length, testStore.getEmployees().size(), .001);
    }

    /*
     * Test the getCurrentSales method.
     */
    @Test
    public void testGetCurrentSales() {
        assertEquals(STORE_CURRENT_SALES, testStore.getCurrentSales(), .001) ;
    }

    @Test
    public void testGetTotalCommissions() {
        assertEquals(STORE_COMMISSIONS, testStore.getTotalCommissions(), .50);
    }

    /*
     * Test a number of employee and store calculations.
     */
    @Test
    public void testNumbers() {
        assertEquals(MANAGER_PAY, manager.calculatePay(), .001);
        assertEquals(OFFICE_EMP_PAY, officeEmp.calculatePay(), .001);
        assertEquals(ASS0CIATE01_PAY, salesAssociate01.calculatePay(), .001);
        assertEquals(ASSOCIATE02_PAY, salesAssociate02.calculatePay(), .001);
        assertEquals(ASSOCIATE03_PAY, salesAssociate03.calculatePay(), .001);
        assertEquals(STORE_CURRENT_SALES, testStore.getCurrentSales(), .001);
    }



//    @Test
//    public void testPrintPayroll() {
//        testStore.processPayroll();
//        testStore.printPayroll();
//    }
//
//    @Test
//    public void testPrintEmployees() {
//        testStore.printEmployees();
//    }

//    @Test
//    public void testSomeThings() {
//        System.out.println("Store current sales: " + testStore.getCurrentSales());
//        System.out.println("Mgr currentSales: " + manager.getCurrentSales());
//        System.out.println("Mgr currentStoreSales: " + manager.getCurrentStoreSales());
//        System.out.println("Mgr base pay: " + MANAGER_PAY);
//        System.out.println("Mgr commission: " + manager.calculateCommission());
//        System.out.println("Mgr calculatePay: " + manager.calculatePay());
//        System.out.println("Store total commission: " + testStore.getTotalCommissions());
//    }

}
