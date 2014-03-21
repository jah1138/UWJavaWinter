package edu.washington.ext.libraryproject.common;

//import edu.washington.ext.libraryproject.model.*;
import edu.washington.ext.libraryproject.model.Patron;

import java.util.Date;

// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.FD6EFDA1-D715-94D9-AF44-FEC5DE2F02F3]
// </editor-fold> 
public abstract class AbstractLibraryItem implements LibraryItem {
    private String title;
    private Date   publishedDate;
    private String author;
    private String publisher;
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
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @return the publishedDate
     */
    public Date getPublishedDate() {
        return publishedDate;
    }

    /**
     * @return the author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * @return the publisher
     */
    public String getPublisher() {
        return publisher;
    }

    /**
     * @return the checkedOut
     */
    public Patron getCheckedOutPatron() {
        return checkedOut;
    }

    /**
     * @param checkedOut the checkedOut to set
     */
    public void setCheckedOut(Patron checkedOut) {
        this.checkedOut = checkedOut;
    }

    @Override
    public String toString() {
        return super.toString();
    }



}

