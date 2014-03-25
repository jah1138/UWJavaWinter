package edu.washington.ext.libraryproject.model;

/**
 * Enum which contains the list of movie genres which can be assigned to
 * movie items in the library.
 * @author Alex Harris
 * @version 3/23/2014
 */
public enum MovieGenre {

    ACTION("Action"),
    ADVENTURE("Adventure"),
    COMEDY("Comedy"),
    CRIME("Crime"),
    DOCUMENTARY("Documentary"),
    DRAMA("Drama"),
    FAMILY("Family");

    /** Movie genre field. */
    private final String movieGenre;

    /**
     * Constructor for the movie genre object.
     * @param movieGenre The movie genre selected from the list.
     */
    MovieGenre(final String movieGenre) {
        this.movieGenre = movieGenre;
    }

    /**
     * Returns the movie genre.
     * @return the movie genre.
     */
    public String getMovieGenre() {
        return movieGenre;
    }
}




