package edu.washington.ext.libraryproject.controller;

import edu.washington.ext.libraryproject.common.LibraryItem;

/** An exception to respond to errors in general library operations.
 * @author Alex Harris
 * @version 3/23/2014
 */
 class LibraryException extends Exception {

    /** The item associated with the exception. */
    private LibraryItem item = null;

    /** The exception
     * @param item The item associated with the exception.
     * @param message A message describing the exception.
     */
    public LibraryException(LibraryItem item, String message) {
        super(message);
        this.item = item;
    }
}
