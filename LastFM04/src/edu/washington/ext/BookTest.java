package edu.washington.ext;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;

public class BookTest {

    private static String goodDescription = "We hold these truths to be self-evident, " +
            "that all men are created equal, that they are endowed by their Creator " +
            "with certain unalienable Rights, that among these are Life, Liberty, and " +
            "the pursuit of Happiness. That to secure these rights, Governments are " +
            "instituted among Men, deriving their just powers from the consent of the " +
            "governed. That whenever any Form of Government becomes destructive of " +
            "these ends, it is the Right of the People to alter or to abolish it, and " +
            "to institute new Government, laying its foundation on such principles and " +
            "organizing its powers in such form, as to them shall seem most likely to " +
            "effect their Safety and Happiness.";
    private static int goodTotalWords = 110;
    private static int goodUniqueWords = 71;
    private static Map<String, Integer> testWordsToCount = new HashMap<String, Integer>();

    Book testBook;
    @Before
    public void setup() {
        testBook = new Book("Cay Horstmann", "Core Java Vol 1, 9th Ed", goodDescription, "Prentice Hall",
                Binding.EPUB, 0);
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

    @Test
    public void testGetTotalWordInDescription() {
//        String bookDescription = testBook.getDescription();
//        bookDescription = testBook.getDescription().replace(",", "");
        Set keys = testWordsToCount.keySet();
//        System.out.println("keyset = " + keys);  //debug
        for (Object key : keys) {
            StringTokenizer st = new StringTokenizer(testBook.sanitizedDescription);
            int wordCount = 0;
//            String newKey = (String)key;
//            System.out.println("key = " + key);  //debug
            while (st.hasMoreTokens()) {
                String word = st.nextToken().toLowerCase();
//                System.out.println("word = " + word);  //debug
                if (key.equals(word)) {
                    wordCount++;
                    System.out.println("wordCount = " + wordCount);  //debug
                }
            }
            System.out.println("testWordsToCount.get(key): " + testWordsToCount.get(key));
            System.out.println("wordCount: " + wordCount);
            assertTrue(testWordsToCount.get(key) == wordCount);
        }
    }
}
