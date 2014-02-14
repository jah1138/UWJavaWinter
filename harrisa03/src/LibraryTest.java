import org.junit.Test;
/**
 * Library test class
 * @author Alex Harris
 */
public class LibraryTest {

    Library library = new Library();

    @Test
    public void printTest() {
        addSomeEntries();
        printSomeEntries();
        returnSomeItems();
        printSomeEntries();
    }

    void addSomeEntries() {
        library.checkoutBook("000", "Cay Horstman");
        library.checkoutBook("000", "Sharron Morrow");
        library.checkoutBook("001", "Gail House");
        library.checkoutBook("001", "Julie Hill");
        library.checkoutBook("002", "Jimmy Dean");
        library.checkoutBook("002", "Sherry Crow");
    }

    void printSomeEntries() {
        library.printCheckoutBooksByIsbn("000");
        library.printCheckoutBooksByIsbn("001");
        library.printCheckoutBooksByIsbn("002");
    }

    void returnSomeItems() {
        library.returnBook("001", "Gayle Walker");
        library.returnBook("001", "Julie Hill");
        library.printCheckoutBooksByIsbn("001");

    }
}