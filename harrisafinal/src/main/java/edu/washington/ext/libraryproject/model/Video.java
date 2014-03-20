package edu.washington.ext.libraryproject.model;

import edu.washington.ext.libraryproject.common.AbstractLibraryItem;

import java.util.Date;


public class Video extends AbstractLibraryItem {
    private MediaType mediaType = null;
    private MovieGenre genre = null;
    private String director = null;
    private String producer = null;
    
    public Video(String title, String author, 
                 String publisher, Date publishedDate,
                 MediaType mediaType,
                 String director, String producer,
                 MovieGenre genre) {
        super(title, author, publisher, publishedDate);
        this.director = director;
        this.producer = producer;
        this.mediaType = mediaType;
    }


    /**
     * @return the mediaType
     */
    public MediaType getMediaType() {
        return mediaType;
    }

    /**
     * @return the genre
     */
    public MovieGenre getGenre() {
        return genre;
    }

    /**
     * @return the director
     */
    public String getDirector() {
        return director;
    }

    /**
     * @param director the director to set
     */
    public void setDirector(String director) {
        this.director = director;
    }

    /**
     * @return the producer
     */
    public String getProducer() {
        return producer;
    }
}

