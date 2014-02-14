//To complete the Library class you will need to:
//
// Add the appropriate import statements.
// Complete the declaration of the checkoutBooks HashMap. Use generics to specify the key and value types.
// In this case, the key is isbn number of book and value is an list of 1 or more patrons that have borrowed this book.
// Implement the constructor to initialize the HashMap.
// Implement the checkoutBook(String,String) method. This is an isbn for book and one patron thats checking it out
// Define and implement the checkoutBook(String,String variable argument list) method declaration and implement
// the method. This is an isbn for a book and any number of patrons that are checking it out.
// Define and Implement the returnBook(String,String) method. Is isbn for book and person return the book
// Define and Implement the printCheckoutBooksByIsbn(String) method by isbn number only
// Optional, Define and implement printAllCheckoutBooks() method

// Add the appropriate imports
import java.util.HashMap;
import java.util.ArrayList;

/**
 *
 * @author Alex Harris
 */
public class Library {

    /**
     * All checked out Books are stored in this map. The HashMap
     * has a String key for the isbn and the data is a String
     * with patron's name
     */
    private String isbn = "";
    private String patron = "";
    private HashMap<String, ArrayList<String>> checkoutBooks;
//    private ArrayList<String> patrons;

    /**
     * Constructor, initializes the entries HashMap.
     */
    Library() {
        // perform initialization here
        checkoutBooks = new HashMap<String, ArrayList<String>>();
    }

    /**
     * add isbn book checked out to patron
     */
    public void checkoutBook(String isbn, String patron) {
        this.isbn = isbn;
        this.patron = patron;
        ArrayList<String> patrons = new ArrayList<String>();
        patrons.add(patron);
        checkoutBooks.put(isbn, patrons);
    }

    /**
     * patron returns a checked out book
     */
    public void returnBook(String isbn, String patron) {
       checkoutBooks.get(isbn).contains(patron) ? checkoutbooks.put );
        checkoutBooks.remove(this.isbn);
    }

    /**
     * print a checked out book by isbn
     */
    public void printCheckoutBooksByIsbn(String isbn) {
        System.out.println("ISBN: " + isbn + "\tPatron: " + checkoutBooks.get(isbn));
    }

    /**
     * print all checked out books by isbn
     */
    public void printAllCheckoutBooks() {
        for (String isbn : checkoutBooks.keySet()) {
            printCheckoutBooksByIsbn(isbn);
        }
    }
}