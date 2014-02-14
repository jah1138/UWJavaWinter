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
<<<<<<< HEAD
        /* He placed this checking / creating code in a separate method then
        called it from all the other methods */
=======
>>>>>>> 70eb0774b7b5344c9a22ea34bffa3f709175e3a5
        ArrayList<String> patrons = checkoutBooks.get(isbn);
        if(patrons == null) {
            patrons = new ArrayList<String>();
            patrons.add(patron);
            checkoutBooks.put(isbn, patrons);
        }
        else {
            if(!patrons.contains(patron)) {
                patrons.add(patron);
            }
        }
    }

    /**
     * patron returns a checked out book
     */
    public void returnBook(String isbn, String patron) {
       if (checkoutBooks.get(isbn).contains(patron)) {
            checkoutBooks.get(isbn).remove(patron);
        }
        else {
            System.out.println("There is no record of book " + isbn +
                    " being checked out to " + patron);
        }
    }

    /**
     * print a checked out book by isbn
     */
    public void printCheckoutBooksByIsbn(String isbn) {
        // He put a test here to check that the isbn was in the library
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