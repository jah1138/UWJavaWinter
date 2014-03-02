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

    final double MANAGER_PAY = 4502.50;
    final double OFFICE_EMP_PAY = 1680.00;
    final double ASS0CIATE01_PAY = 2025.00;
    final double ASSOCIATE02_PAY = 2920.00;
    final double ASSOCIATE03_PAY = 3750.00;
    final double STORE_CURRENT_SALES = 100500.00;

    private Store testStore;
    private Manager manager;
    private StoreEmployee officeEmp;
    private SalesAssociate salesAssociate01;
    private SalesAssociate salesAssociate02;
    private SalesAssociate salesAssociate03;

    @Before
    public void setUp() {

        /* Create test data */

        testStore = new Store(1);

        testStore.setManager(manager = new Manager("Joe Manager"));
        testStore.addEmployee(officeEmp = new StoreEmployee("Janet OfficeEmployee"));
        testStore.addEmployee(salesAssociate01 = new SalesAssociate("Alan Associate01"));
        testStore.addEmployee(salesAssociate02 = new SalesAssociate("Bob Associate02"));
        testStore.addEmployee(salesAssociate03 = new SalesAssociate("Carol Associate03"));
        manager.setCurrentStoreSales(STORE_CURRENT_SALES);

        manager.setBasePay(4000.00);
        manager.setCurrentSales(10000.00);
        Manager.setBonusRate(.005);

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
        assertNotNull(testStore.getPayroll());
        assertNotNull(testStore.getEmployees());
        assertEquals(testStore.getPayroll().length, testStore.getEmployees().size(), .001);
    }

    /*
     * Test the getCurrentSales method.
     */
    @Test
    public void testGetCurrentSales() {
        assertEquals(testStore.getCurrentSales(), STORE_CURRENT_SALES, .001) ;
    }

    /*
     * Test a number of employee and store calculations.
     */
    @Test
    public void testNumbers() {
        assertEquals(manager.calculatePay(), MANAGER_PAY, .001);
        assertEquals(officeEmp.calculatePay(), OFFICE_EMP_PAY, .001);
        assertEquals(salesAssociate01.calculatePay(), ASS0CIATE01_PAY, .001);
        assertEquals(salesAssociate02.calculatePay(), ASSOCIATE02_PAY, .001);
        assertEquals(salesAssociate03.calculatePay(), ASSOCIATE03_PAY, .001);
        assertEquals(testStore.getCurrentSales(), STORE_CURRENT_SALES, .001);
    }

//    @Test
//    public void testPrintPayroll() {
//        testStore.processPayroll();
//        testStore.printPayroll();
//    }

//    @Test
//    public void testPrintEmployees() {
//        testStore.printEmployees();
//    }

}
