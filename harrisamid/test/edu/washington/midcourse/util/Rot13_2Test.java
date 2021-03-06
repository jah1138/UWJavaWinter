package edu.washington.midcourse.util;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests the edu.washington.midcourse.util.Rot13_2 class
 *
 * @author Alex Harris
 * @version 2/20/2014
 */
public class Rot13_2Test {

    private static final String TEST_STRING = "Hello there. Testing, testing!";
    private static final String ENCRYPTED_STRING = "Uryyb gurer. Grfgvat, grfgvat!";

    Rot13_2 encrypter;
    @Before
    public void setup() {
        encrypter = new Rot13_2();
    }

    /**
     * Tests the encrypt method.
     */
    @Test
    public void testEncrypt() {
        assertEquals(ENCRYPTED_STRING, encrypter.encrypt(TEST_STRING));
        assertEquals("", encrypter.encrypt(""));
        assertEquals("nopqrstuvwxyzNOPQRSTUVWXYZ", encrypter.encrypt("abcdefghijklmABCDEFGHIJKLM"));
        assertEquals("abcdefghijklmABCDEFGHIJKLM", encrypter.encrypt("nopqrstuvwxyzNOPQRSTUVWXYZ"));
    }
}
