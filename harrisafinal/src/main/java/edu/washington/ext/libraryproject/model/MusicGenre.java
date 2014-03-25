package edu.washington.ext.libraryproject.model;

/**
 * Enum which contains the list of music genres which can be assigned to
 * recorded music items in the library.
 * @author Alex Harris
 * @version 3/23/2014
 */
public enum MusicGenre {

    POP("Pop"),
    DANCE("Dance"),
    HIPHOP("Hip Hop"),
    RAP("Rap"),
    ROCK("Rock"),
    ALTERNATIVE("Alternative"),
    HARDROCK("Hard rock"),
    FOLK("Folk"),
    COUNTRY("Country"),
    CLASSICAL("Classical"),
    OPERA("Opera");

    /** The field which stores the genre. */
    private final String musicGenre;

    /**
     * Constructs a musicGenre object of the type selected from the list.
     * @param musicGenre the music genre.
     */
    MusicGenre(final String musicGenre) {
        this.musicGenre = musicGenre;
    }

    /**
     * Returns the music genre.
     * @return the music genre.
     */
    public String getMusicGenre() {
        return musicGenre;
    }

}
