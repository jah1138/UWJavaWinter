package edu.washington.ext;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;

public class BookTest {

    private static final String goodDescription = "We hold these truths to be self-evident, " +
            "that all men are created equal, that they are endowed by their Creator " +
            "with certain unalienable Rights, that among these are Life, Liberty, and " +
            "the pursuit of Happiness. That to secure these rights, Governments are " +
            "instituted among Men, deriving their just powers from the consent of the " +
            "governed. That whenever any Form of Government becomes destructive of " +
            "these ends, it is the Right of the People to alter or to abolish it, and " +
            "to institute new Government, laying its foundation on such principles and " +
            "organizing its powers in such form, as to them shall seem most likely to " +
            "effect their Safety and Happiness.";
    private static final int goodTotalWords = 110;
    private static final int goodUniqueWords = 71;
    private static final Map<String, Integer> testWordsToCount = new HashMap<String, Integer>();

    Book testBook;
    @Before
    public void setup() {
        testBook = new Book("Cay Horstmann", "Core Java Vol 1, 9th Ed", goodDescription, "Prentice Hall",
                Binding.EPUB);
        testWordsToCount.put("rights", 2);
        testWordsToCount.put("to", 7);
    }

    @Test
    public void testGetDescription() {
        String bookDescription = testBook.getDescription();
        assertTrue(goodDescription.equals(bookDescription));
    }

    @Test
    public void testSetDescription() {
        String testWord = "Test";
        String bookDescription = testBook.getDescription();
        testBook.setDescription(testWord);
        assertTrue(testWord.equals(testBook.getDescription()));
        testBook.setDescription(bookDescription);
    }

    @Test
    public void testGetTotalWordsInDescription() {
        int bookTotalWords = testBook.getTotalWordsInDescription();
        assertEquals(goodTotalWords, bookTotalWords);
    }

    @Test
    public void testGetTotalUniqueWordsInDescription() {
        int bookUniqueWords = testBook.getTotalUniqueWordsInDescription();
        assertEquals(goodUniqueWords, bookUniqueWords);
    }

     /*
    I designed the word count test to handle multiple tests in one method call.
    The test parameters are contained in the testWordsToCount HashMap in the setup.
     */
    @Test
    public void testGetTotalWordInDescription() {
        Set keys = testWordsToCount.keySet();
        for (Object key : keys) {
            String testWord = (String)key;
            assertTrue(testWordsToCount.get(key) == testBook.getTotalWordInDescription(testWord));
        }
    }
}
