/**
 * Created by Alex on 1/30/14.
 * A selection of different bindings for a book.
 */
public enum Binding {
    HARDCOVER,
    PAPERBACK,
    EPUB,
    MOBI,
    APK
}




//Other ways to make lowercase:

// You can set enums like HARCOVER("hardcover"), etc.
    // then
    // private String getBinding;

    //then a constructor which uses getBindind
    //public Binding(String getBinding( {
    //    this.binding(getBinding)
    // }
    // or something like this. Then call from Book.

// override toString() to make it lowe case, then when calling from Book
// can just use toString() without doing toLowerCase() for each one.
public String toString() {
    return super.toString().toLowerCase();
}