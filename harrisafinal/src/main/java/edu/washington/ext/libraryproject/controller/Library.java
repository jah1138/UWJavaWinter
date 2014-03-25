package edu.washington.ext.libraryproject.controller;

import edu.washington.ext.libraryproject.model.Binding;
import edu.washington.ext.libraryproject.common.LibraryItem;
import edu.washington.ext.libraryproject.model.Patron;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Creates a library object which performs various functions common to lending
 * libraries. Manages various kinds of media and the library patrons.
 * @author Alex Harris
 * @version 3/23/2014
 */
public class Library {

    /** The class fields */
    private int nextCardNumber = 52374;
    private List<LibraryItem> items = null;
    private Map<Integer, Patron> patrons = null;
    private Map<Integer, LibraryItem> checkedOutItems = null;
    private String branch = null;

    /**
     * Constructs a library object with a branch specifier.
     * @param branch Library branch.
     */
    public Library (String branch) {
        items = new ArrayList<LibraryItem>();
        patrons = new HashMap<Integer, Patron>();
        checkedOutItems = new HashMap<Integer, LibraryItem>();
    }

    /**
     * Prints the list of available media bindings.
     */
    public void printBinding() {
//        for (Binding b : Binding.values()) {
//            System.out.println(b);
        System.out.println(java.util.Arrays.toString(Binding.values()));
    }

    /**
     * Adds a new object to the library collection.
     * @param item The item to add.
     * @throws LibraryException If the item is already contained in the library.
     */
    public void add(LibraryItem item) throws LibraryException {
        if (isInLibraryCollection(item)) {
            throw new LibraryException(item, item.getTitle() + " is already in the library collection.");
        }
        items.add(item);
    }

    /**
     * Removes an item from the library's collection.
     * @param item The item to remove.
     * @throws LibraryException If the item is not in the library collection.
     * @throws CheckInOutException If the item is currently checked out.
     */
    public void remove(LibraryItem item) throws LibraryException, CheckInOutException {
        if (!isInLibraryCollection(item)) {
            throw new LibraryException(item, item.getTitle() + " is not in the library collection.");
        }
        if (isCheckout(item)) {
            throw new LibraryException(item, item.getTitle() + " is currently checked out.");
        }
        items.remove(item);
    }

    /**
     * Adds a new patron and returns a unique library number.
     * @param name The name of the patron to be added.
     * @return A unique library ID number assigned to the patron.
     * @throws PatronException If the name is already exists in the list of patrons.
     */
    public int addPatron(String name) throws PatronException {
        for (int i = 0; i < patrons.size(); i++) {
            Patron patron = patrons.get(i);
            if (patron.getName().equalsIgnoreCase(name)) {
                throw new PatronException(patron, "Name " + name + " is already in use.");
            }
        }
        Patron patron = new Patron(name, nextCardNumber);
        patrons.put(nextCardNumber, patron);
        nextCardNumber ++;
        return patron.getCardNumber();
    }

    /**
     * Removes a patron from the list of library patrons.
     * @param libraryCardNumber The ID number of the patron to be removed.
     * @return True if the patron was successfully removed.
     * @throws PatronException if the patron number is not found in the list of patrons.
     */
    public boolean removePatron(int libraryCardNumber) throws PatronException {
        if (!patrons.containsKey(libraryCardNumber)) {
            throw new PatronException("Patron not found.");
        }
        patrons.remove(libraryCardNumber);
        return true;
    }

    /**
     * Checks out an item from the library.
     * @param item The item to be checked out.
     * @param libraryCardNumber The ID number of the patron who is checking out the item.
     * @throws LibraryException If the item is not listed as part of the library collection.
     * @throws CheckInOutException If the item is already checked out.
     */
    public void checkout(LibraryItem item, int libraryCardNumber) throws LibraryException, CheckInOutException {
        if (!isInLibraryCollection(item)) {
            throw new LibraryException(item, item.getTitle() + " is not in the library collection");
        }
        if (isCheckout(item)) {
            throw new CheckInOutException(item.getTitle() + " is already checked out.");
        }
        checkedOutItems.put(libraryCardNumber, item);
        item.setCheckedOut(patrons.get(libraryCardNumber));
    }

    /**
     * Checks an item back into the library.
     * @param item The item to check in.
     * @throws LibraryException If the item is not listed as part of the library collection.
     * @throws CheckInOutException If the item is not checked out.
     */
    public void checkin(LibraryItem item) throws LibraryException, CheckInOutException {
        if (!isInLibraryCollection(item)) {
            throw new LibraryException(item, item.getTitle() + " is not in the library collection");
        }
        if (!isCheckout(item)) {
            throw new CheckInOutException(item.getTitle() + " is not checked out.");
        }
        checkedOutItems.remove(item.getCheckedOutPatron().getCardNumber());
        item.setCheckedOut(null);
    }

    /* Utility methods for checking the status of individual items */

    /**
     * Checks to see if a referenced item exists in the library collection.
     * @param item The item to check for.
     * @return True if the item is listed as part of the library collection.
     * @throws LibraryException If the item is not listed in the library collection.
     */
    private boolean isInLibraryCollection(LibraryItem item) throws LibraryException {
        return (!items.contains(item));
    }

    /**
     * Checks to see if an item is currently checked out.
     * @param item The item to check.
     * @return True if the item is checked out; False if the item is not checked out.
     * @throws LibraryException If the item is not listed in the library collection.
     */
    public boolean isCheckout(LibraryItem item) throws LibraryException {
        isInLibraryCollection(item);
        return checkedOutItems.containsValue(item);
    }

    /* Methods to get the collections associated with the library. */

    /**
     * Returns the HashMap containing all patrons.
     * @return HashMap of library patrons.
     */
    public Map<Integer, Patron> getLibraryMembers() {
        return patrons;
    }

    /**
     * Returns the HashMap containing all checked out items.
     * @return List of checked out items.
     */
    public Map<Integer, LibraryItem> getCheckedOutItems() {
        return checkedOutItems;
    }

    /**
     * Returns the ArrayList containing all items in the library collection.
     * @return ArrayList of all library items.
     */
    public List<LibraryItem> getListOfAllLibraryItems() {
        return items;
    }

}

