/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.washington.ext.libraryproject.model;


/**
 *
 * @author appleman
 */
public class Patron {
    private String name = null;
    private int cardNumber = 0;

    public Patron(String name, int cardNumber) {
        this.name = name;
        this.cardNumber = cardNumber;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the cardNumber
     */
    public int getCardNumber() {
        return cardNumber;
    }


}
