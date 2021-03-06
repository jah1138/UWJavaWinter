package edu.washington.ext.libraryproject.model;

import edu.washington.ext.libraryproject.common.AbstractLibraryItem;
import java.util.Date;

/**
 * A class that maintains information on a book. This might form part of a
 * larger application such as a library system, for instance.
 * @author Alex
 * @version 3/23/2014
 */
public class Book extends AbstractLibraryItem {

    /** The type of media binding. */
    private final Binding binding;

    /** The number of pages. */
    private final int pages;

    /**
     * Constructor. Set the author, title and binding fields when this object is
     * constructed.
     *
     * @param author the author
     * @param title the title
     * @param bindingType the type of binding
     * @param pages the total number pages
     */
    public Book(final String title, final String author, final String publisher, final Date publishedDate,
                final Binding bindingType, final int pages) {
        super(title, author, publisher, publishedDate);
        this.binding = bindingType;
        this.pages = pages;
    }

    /**
     * Gets the binding type.     *
     * @return the binding type.
     */
    public Binding getBinding() {
        return binding;
    }

    /**
     * Gets the number of pages.     *
     * @return the number of pages
     */
    public int getPages() {
        return pages;
    }

}
