package edu.washington.ext.libraryproject.controller;

import edu.washington.ext.libraryproject.model.Patron;

/**An exception to respond to errors involving patron management.
 * @author Alex Harris
 * @version 3/23/2014
 */
public class PatronException extends Exception {

    /** Instance variables to record exception information. */
    private Patron patron;
    private String name;

    /**
     * Exception with message only.
     * @param message Message describing the exception.
     */
    public PatronException(String message) {
        super(message);
    }

    /**
     * Exception which includes the patron involved in the exception.
     * @param patron The patron involved in the exception.
     * @param name The patron's name.
     */
    public PatronException(Patron patron, String name) {
        this.patron = patron;
        this.name = name;
    }
}
