package edu.washington.ext.libraryproject.controller;

import edu.washington.ext.libraryproject.model.Binding;
import libraryproject.LibraryException;
import edu.washington.ext.libraryproject.common.LibraryItem;
import edu.washington.ext.libraryproject.model.Patron;

import java.util.List;
import java.util.Map; 

// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.2FEFDCA2-EC7B-D0BE-1272-223B5E6BD078]
// </editor-fold> 
public class Library {

    private List<LibraryItem> items = null;
    private Map<Integer, Patron> patrons = null;
    private Map<Integer, LibraryItem> checkedOutItems = null;
    private String branch = null;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.BB0EE4F5-FAE9-F758-28D3-AD613B04A35C]
    // </editor-fold> 
    public Library (String branch) {
    }

    public void printBinding() {
//        for (Binding b : Binding.values()) {
//            System.out.println(b);
        System.out.println(java.util.Arrays.toString(Binding.values()));
    }

    public void add(LibraryItem item) throws LibraryException {

    }

    public void remove(LibraryItem item) throws LibraryException {

    }


    /**
     * Adds new patrons and returns library number
     * @param name of patron
     * @return library card number
     */
    public int addPatron(String name) throws PatronException {
        return 0;
    }

    public boolean removePatron(int libraryCardNumber) throws PatronException {
        return false;
    }


    public void checkout(LibraryItem item, int libraryCardNumber) throws CheckInOutException {

    }

    public boolean isCheckout(LibraryItem item) throws CheckInOutException {
        return false;
    }

    public void checkin(LibraryItem item) throws CheckInOutException {
        
    }

    public Map<Integer, Patron> getLibraryMembers() {
        return patrons;
    }

    public Map<Integer, LibraryItem> getCheckedOutItems() {
        return checkedOutItems;
    }

    public List<LibraryItem> getListOfAllLibraryItems() {
        return items;
    }
}

