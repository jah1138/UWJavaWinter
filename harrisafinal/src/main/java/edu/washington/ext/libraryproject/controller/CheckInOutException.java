package edu.washington.ext.libraryproject.controller;

/**
 *An exception to respond to errors when checking library items in or
 * out of the library.
 * @author Alex Harris
 * @version 3/23/2014
 */
class CheckInOutException extends Exception {

    /**
     * The exception.
     * @param message Message describing the exception.
     */
    public CheckInOutException(String message) {
        super(message);
    }
}
