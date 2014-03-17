package edu.washington.ext.libraryproject.model.common;

import org.junit.Test;

/**
 * Created by Alex on 3/2/14.
 */
public class LibraryTest {
    @Test
    public void testPrintBinding() throws Exception {
        Library l = new Library("testBranch");
        l.printBinding();
    }
}
