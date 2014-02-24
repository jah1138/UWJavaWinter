package edu.washington.midcourse.util;

/**
 * This class creates an encryption object which can be used to encrypt
 * strings using Rot13 encryption.
 *
 * @author Alex Harris
 * @version 2/20/2014
 */
public class Rot13 {

    /**
     * Creates a Rot13 encryption object which can be used to encrypt
     * strings using Rot13 encryption.
     */
    public Rot13() {
    }

    /**
     * Encrypts a string using Rot13 encryption.
     *
     * @param stringToEncrypt The string to encrypt.
     * @return The encrypted string.
     */
    public String encrypt(String stringToEncrypt){

        char[] encrypted = new char[stringToEncrypt.length()];
        for (int i = 0; i < stringToEncrypt.length(); i++) {
            char thisChar = stringToEncrypt.charAt(i);
            if ((thisChar >= 65 && thisChar <= 90) || (thisChar >=97 && thisChar <= 122)) {
                if ((thisChar + 13 > 122) || ((thisChar <= 90) && (thisChar + 13 > 90))) {
                    encrypted[i] = (char)(thisChar - 13);
                }
                else {
                    encrypted[i] = (char)(thisChar + 13);
                }
            }
            else {
                encrypted[i] = thisChar;
            }
        }
        return new String(encrypted);
    }
}