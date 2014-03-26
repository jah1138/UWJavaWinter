package edu.washington.ext.libraryproject.controller;

import edu.washington.ext.libraryproject.model.*;
import edu.washington.ext.libraryproject.controller.*;
import edu.washington.ext.libraryproject.common.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Date;

/**
 * Author: Alex
 * Version: 3/23/2014.
 */
public class LibraryTest {

    final String PATRON_01 = "Randy Hanford";
    final String PATRON_02 = "Stuart Maclean";
    final String PATRON_03 = "Russ Moul";

    private Library testLibrary;
    private Book testBook01;
    private Book testBook02;
    private Music testMusic01;

    @Before
    public void setUp() {

        /* Create test data */

        testLibrary = new Library("Seattle");

        testBook01 = new Book("Core Java", "Cay Horstmann", "Prentice Hall",
                new Date(1354856400000L), Binding.PAPERBACK, 1008);
        testBook02 = new Book("Anna Karenina", "Leo Tolstoy", "Barnes & Noble",
                new Date(852094800000L), Binding.PAPERBACK, 736);
        testMusic01 = new Music("Rusalka", "Antonin Dvorak", "London",
                new Date(883630800000L), MediaType.CD, "Mackerras", MusicGenre.OPERA);
    }

    @Test
    public void testPrintBinding() {
        testLibrary.printBinding();
    }

    @Test (expected = LibraryException.class)
    public void testAdd() throws LibraryException {
        testLibrary.clearAllItems();
        testLibrary.add(testBook01);
     assertTrue(testLibrary.getListOfAllLibraryItems().contains(testBook01));
        testLibrary.add(testBook01);
    }

    @Test (expected = LibraryException.class)
    public void testRemove01() throws Exception {
        testLibrary.clearAllItems();
        assertTrue(!testLibrary.getListOfAllLibraryItems().contains(testBook02));
        testLibrary.remove(testBook02);
    }

    @Test (expected = LibraryException.class)
    public void testRemove02() throws Exception {
        testLibrary.clearAllItems();
        testLibrary.add(testBook02);
        Patron p = new Patron("Test Patron", 2345);
        testLibrary.checkout(testBook02, 2345);
        testLibrary.remove(testBook02);
    }

    @Test (expected = PatronException.class)
    public void testAddPatron() throws Exception {
        testLibrary.addPatron("Test Patron");
        testLibrary.addPatron("Test Patron");
    }

    @Test
    public void testRemovePatron() throws Exception {

    }

    @Test
    public void testCheckout() throws Exception {

    }

    @Test
    public void testCheckin() throws Exception {

    }

    @Test
    public void testIsCheckout() throws Exception {

    }

    @Test
    public void testGetLibraryMembers() throws Exception {

    }

    @Test
    public void testGetCheckedOutItems() throws Exception {

    }

    @Test
    public void testGetListOfAllLibraryItems() throws Exception {

    }
}
