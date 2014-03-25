package edu.washington.ext.libraryproject.model;

/**
 * Enum which contains the type of disk media for library items.
 * @author Alex Harris
 * @version 3/23/2014
 */
public enum MediaType {

    DVD("dvd"),
    Bluray("bluray"),
    CD("cd");

    /** Field */
    private final String mediaType;

    /**
     * Constructs the MediaType object.
     * @param mediaType the selected media type.
     */
     MediaType(final String mediaType) {
        this.mediaType = mediaType;
    }

    /**
     * Returns the media type.
     * @return the mediaType
     */
    public String getMediaType() {
        return mediaType;
    }
     
}
