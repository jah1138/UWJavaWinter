package edu.washington.ext.libraryproject.controller;

import edu.washington.ext.libraryproject.controller.Library;
import org.junit.Test;

/**
 * Created by Alex on 3/2/14.
 */
public class LibraryTest01 {
    @Test
    public void testPrintBinding() throws Exception {
        Library l = new Library("testBranch");
        l.printBinding();
    }
}
