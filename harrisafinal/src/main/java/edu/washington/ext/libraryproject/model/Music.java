package edu.washington.ext.libraryproject.model;

import edu.washington.ext.libraryproject.common.AbstractLibraryItem;
import java.util.Date;

/**
 * A class that maintains information on a music item. This might form part
 * of a larger application such as a library or music store.
 * @author Alex
 * @version 3/23/2014
 */
public class Music extends AbstractLibraryItem {
    private MediaType mediaType = null;
    private String artist = null;
    private MusicGenre genre = null;

    /**
     * Constructs a music item with complete descriptive parameters.
     * @param title The title
     * @param author The composer
     * @param publisher The publisher
     * @param publishedDate The date of publication
     * @param mediaType The media type
     * @param artist The performer on the recording
     * @param genre The music genre
     */
    public Music(String title, String author, String publisher,
                 Date publishedDate, MediaType mediaType,
                 String artist, MusicGenre genre) {
        super(title, author, publisher, publishedDate);
        this.mediaType = mediaType;
        this.artist = artist;
        this.genre = genre;
    }

    /**
     * Returns the media type of the recording.
     * @return the mediaType
     */
    public MediaType getMediaType() {
        return mediaType;
    }

    /**
     * Returns the artist / performer on the recording.
     * @return the artist
     */
    public String getArtist() {
        return artist;
    }

    /**
     * Returns the genre of music.
     * @return the genre
     */
    public MusicGenre getGenre() {
        return genre;
    }

}

