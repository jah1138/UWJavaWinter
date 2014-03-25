package edu.washington.ext.libraryproject.model;

import edu.washington.ext.libraryproject.common.AbstractLibraryItem;
import java.util.Date;

/**
 * A class that maintains information on a video item. This might form part
 * of a larger application such as a library or video store.
 * @author Alex
 * @version 3/23/2014
 */
public class Video extends AbstractLibraryItem {
    private MediaType mediaType = null;
    private final MovieGenre genre = null;
    private String director = null;
    private String producer = null;

    /**
     * Constructs a video item with complete descriptive parameters.
     * @param title The title
     * @param author The composer
     * @param publisher The publisher
     * @param publishedDate The date of publication
     * @param mediaType The media type
     * @param director The performer on the recording
     * @param producer The performer on the recording
     * @param genre The video genre
     */
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
     * Returns the media type of the recording.
     * @return the mediaType
     */
    public MediaType getMediaType() {
        return mediaType;
    }

    /**
     * Returns the genre of the video content.
     * @return the genre
     */
    public MovieGenre getGenre() {
        return genre;
    }

    /**
     * Returns the director of the video.
     * @return the director
     */
    public String getDirector() {
        return director;
    }

    /**
     * Sets the director of the video.
     * @param director the director to set
     */
    public void setDirector(String director) {
        this.director = director;
    }

    /**
     * Returns the producer of the video.
     * @return the producer
     */
    public String getProducer() {
        return producer;
    }

}

