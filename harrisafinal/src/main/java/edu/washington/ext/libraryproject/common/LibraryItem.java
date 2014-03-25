package edu.washington.ext.libraryproject.common;

import edu.washington.ext.libraryproject.model.Patron;
import java.util.Date;

/**
 * Interface to be used for items that can be found in a library and can be checked
 * out by library patrons.
 * @author Alex Harris
 * @version 3/23/2014
 */
public interface LibraryItem {

    /**
     * Returns the author.
     * @return the author
     */
    String getAuthor();

    /**
     * Returns the patron who currently has the item checked out.
     * @return Patron object
     */
    Patron getCheckedOutPatron();

    /**
     * Returns the publication date of the item.
     * @return the publication date
     */
    Date getPublishedDate();

    /**
     * Returns the publisher.
     * @return the publisher
     */
    String getPublisher();

    /**
     * Returns the title.
     * @return the title
     */
    String getTitle();

    /**
     * Records the Patron which has the item checked out.
     * @param checkedOut the Patron to set as currently having the item checked out.
     */
    void setCheckedOut(Patron checkedOut);

}
