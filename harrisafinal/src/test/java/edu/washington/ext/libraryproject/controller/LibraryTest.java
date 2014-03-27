package edu.washington.ext.libraryproject.controller;

import edu.washington.ext.libraryproject.model.*;
import edu.washington.ext.libraryproject.controller.*;
import edu.washington.ext.libraryproject.common.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * JUnit test for class Library, including tests of all checked exceptions.
 *
 * Author: Alex Harris
 * Version: 3/23/2014.
 */
public class LibraryTest {

    /** Declare test variables */
    private Library testLibrary;
    private Book testBook01;
    private Book testBook02;
    private Music testMusic01;

    /** Initialize library and items */
    @Before
    public void setUp() {

        /** Create test media */
        testBook01 = new Book("Core Java", "Cay Horstmann", "Prentice Hall",
                new Date(1354856400000L), Binding.PAPERBACK, 1008);
        testBook02 = new Book("Anna Karenina", "Leo Tolstoy", "Barnes & Noble",
                new Date(852094800000L), Binding.PAPERBACK, 736);
        testMusic01 = new Music("Rusalka", "Antonin Dvorak", "London",
                new Date(883630800000L), MediaType.CD, "Mackerras", MusicGenre.OPERA);
    }

    /** Test */
    @Test
    public void testPrintBinding() {
        testLibrary = new Library("Seattle");
        testLibrary.printBinding();
    }

    /** Test */
    @Test (expected = LibraryException.class)
    public void testAdd() throws LibraryException {
        testLibrary = new Library("Seattle");
        testLibrary.add(testBook01);
     assertTrue(testLibrary.getListOfAllLibraryItems().contains(testBook01));
        testLibrary.add(testBook01); // throws exception
    }

    /** Test */
    @Test (expected = LibraryException.class)
    public void testRemove() throws Exception {
        testLibrary = new Library("Seattle");
        assertFalse(testLibrary.getListOfAllLibraryItems().contains(testBook02));
        testLibrary.remove(testBook02); // throws exception
        testLibrary.add(testBook02);
        int cardNum = testLibrary.addPatron("Test Patron");
        testLibrary.checkout(testBook02, cardNum);
        testLibrary.remove(testBook02); // throws exception
    }

    /** Test */
    @Test (expected = PatronException.class)
    public void testAddPatron() throws Exception {
        testLibrary = new Library("Seattle");
        testLibrary.addPatron("Test Patron");
        testLibrary.addPatron("Test Patron"); // throws exception
    }

    /** Test */
    @Test
    public void testRemovePatron() throws Exception {
        testLibrary = new Library("Seattle");
        assertFalse(testLibrary.removePatron(999));
        int cardNum = testLibrary.addPatron("Test Patron");
        assertTrue(testLibrary.removePatron(cardNum));
    }

    /** Test */
    @Test
    public void testCheckout() throws Exception {
        testLibrary = new Library("Seattle");
        testLibrary.add(testMusic01);
        int cardNum = testLibrary.addPatron("Test Patron");
        testLibrary.checkout(testMusic01, cardNum);
        assertTrue(testLibrary.isCheckout(testMusic01));
    }

    /** Test */
    @Test
    public void testCheckin() throws Exception {
        testLibrary = new Library("Seattle");
        testLibrary.add(testMusic01);
        int cardNum = testLibrary.addPatron("Test Patron");
        testLibrary.checkout(testMusic01, cardNum);
        assertTrue(testLibrary.isCheckout(testMusic01));
        testLibrary.checkin(testMusic01);
        assertFalse(testLibrary.isCheckout(testMusic01));
    }

    /** Test */
    @Test
    public void testIsCheckout() throws Exception {
        testLibrary = new Library("Seattle");
        testLibrary.add(testBook01);
        int cardNum = testLibrary.addPatron("Test Patron");
        assertFalse(testLibrary.isCheckout(testBook01));
        testLibrary.checkout(testBook01, cardNum);
        assertTrue(testLibrary.isCheckout(testBook01));
    }

    /** Test */
    /* Kind of redundant. Just confirms that the map that is returned is actually
     * the map of all library patrons. */
    @Test
    public void testGetLibraryMembers() throws Exception {
        testLibrary = new Library("Seattle");
        Map<Integer, Patron> map = testLibrary.getLibraryMembers();
        assertTrue(map.equals(testLibrary.getLibraryMembers()));
    }

    /** Test */
    /* Kind of redundant. Just confirms that the list that is returned is actually
     * the list of library items. */
    @Test
    public void testGetCheckedOutItems() throws Exception {
        testLibrary = new Library("Seattle");
        Map<Integer, LibraryItem> map = testLibrary.getCheckedOutItems();
        assertTrue(map.equals(testLibrary.getCheckedOutItems()));
    }

    /** Test */
    @Test
    public void testGetListOfAllLibraryItems() throws Exception {
        testLibrary = new Library("Seattle");
        List<LibraryItem> list = testLibrary.getListOfAllLibraryItems();
        assertTrue(list.equals(testLibrary.getListOfAllLibraryItems()));
    }
}
