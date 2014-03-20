/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.washington.ext.libraryproject.controller;

import edu.washington.ext.libraryproject.model.Patron;

/**
 *
 * @author appleman
 */
public class PatronException extends Exception {
    private Patron patron;

    public PatronException(Patron patron) {
        this.patron = patron;
    }
}
