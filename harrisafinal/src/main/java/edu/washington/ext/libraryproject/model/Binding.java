package edu.washington.ext.libraryproject.model;

/**
 * The Enum Binding that defines binding values for books.
 *@author Alex Harris
 * @version 3/23/2014
 */
public enum Binding {

    HARDCOVER("hardcover"),
    PAPERBACK("paperback"),
    EPUB("epub"),
    MOBI("mobi"),
    APK("apk");

    private final String bindingType;

    /**
     * Instantiates a new binding.
     * @param bindingType the binding type
     */
    Binding(final String bindingType) {
        this.bindingType = bindingType;
    }

    /**
     * Gets the binding type.
     * @return the bindingType
     */
    public String getBindingType() {
        return bindingType;
    }

}
