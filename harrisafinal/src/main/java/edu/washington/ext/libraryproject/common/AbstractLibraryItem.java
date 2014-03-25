package edu.washington.ext.libraryproject.common;

import edu.washington.ext.libraryproject.model.Patron;
import java.util.Date;

/**
 * Abstract class which defines common behavior of items that can be
 * checked out of a library.
 * @author Alex Harris
 * @version 3/20/2014
 */
public abstract class AbstractLibraryItem implements LibraryItem {
    private final String title;
    private final Date   publishedDate;
    private final String author;
    private final String publisher;
    private Patron checkedOut;

//        super((String title, String author, String publisher, Date publishedDate);

    public AbstractLibraryItem(String title, String author, String publisher,
            Date publishedDate) {
        this.title = title;
        this.publishedDate = publishedDate;
        this.author = author;
        this.publisher = publisher;
    }


    /**
     * Returns the title of the library item.
     * @return the title.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Returns the date of publication of the library item.
     * @return the publishedDate.
     */
    public Date getPublishedDate() {
        return publishedDate;
    }

    /**
     * Returns the author/creator/composer of the library item.
     * @return the author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Returns the publisher of the library item.
     * @return the publisher
     */
    public String getPublisher() {
        return publisher;
    }

    /**
     * Returns the Patron object which is recorded as currently having the item
     * checked out.
     * @return the Patron who has the item checked out
     */
    public Patron getCheckedOutPatron() {
        return checkedOut;
    }

    /**
     * Creates a reference to the Patron object recorded as having the item
     * currently checked out.
     * @param checkedOut the checkedOut to set
     */
    public void setCheckedOut(Patron checkedOut) {
        this.checkedOut = checkedOut;
    }

//    /**
//     * Returns a string representation of the library item in the format specified
//     * by the superclass.
//     * @return the string representation of the item
//     */
//    @Override
//    public String toString() {
//        return super.toString();
//    }

}

