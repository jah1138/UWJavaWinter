package edu.washington.ext.libraryproject.model;


/**
 * Creates a patron object with a name and an identifying number. The patron
 * can be used in situations where a more complex person class is not needed.
 * @author Alex Harris
 * @version 3/23/2014
 */
public class Patron {
    private String name = null;
    private int cardNumber = 0;

    /**
     * Constructs a Patron.
     * @param name Patron name.
     * @param cardNumber Patron's unique identifying number.
     */
    public Patron(final String name, int cardNumber) {
        this.name = name;
        this.cardNumber = cardNumber;
    }

    /**
     * Returns the patron's name.
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the patron's unique number.
     * @return the cardNumber
     */
    public int getCardNumber() {
        return cardNumber;
    }


}
