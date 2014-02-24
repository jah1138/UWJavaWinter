package edu.washington.midcourse.util;

import java.util.List;
import static java.util.Arrays.asList;

/**
 * This class creates an encryption object which can be used to
 * encrypt strings using Rot13 encryption.
 *
 * This class uses a slightly different implementation from
 * the edu.washington.midcourse.util.Rot13 class.
 *
 * @author Alex Harris
 * @version 2/20/2014
 */
public class Rot13_2 {

    private final String FIRST_13 = "abcdefghijklmABCDEFGHIJKLM";
    private final String LAST_13 = "nopqrstuvwxyzNOPQRSTUVWXYZ";

    Rot13_2() {
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
            if (FIRST_13.indexOf(thisChar) != -1) {
                encrypted[i] = (char)(thisChar + 13);
            }
            else if (LAST_13.indexOf(thisChar) != -1) {
                encrypted[i] = (char)(thisChar - 13);
            }
            else {
                encrypted[i] = thisChar;
            }
        }
        return new String(encrypted);
    }
}