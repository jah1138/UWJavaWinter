/**
 * A class that maintains information on a book.
 * This might form part of a larger application such
 * as a library system, for instance.
 *
 * @author Alex Harris
 * @version January 30, 2014
 */
class Book {

    // The fields.
    private String author = "";
    private String title = "";
    private String publisher = "";
    private Binding binding = null;
    private int pages = 0;
    private String refNumber = null;

    /**
     * Constructor. Set the author, title and binding fields when this object
     * is constructed.
     */
    Book(){
        this("AuthorName", "BookTitle", "BookPublisher", null, 0);
    }

    Book(String bookAuthor, String bookTitle, String bookPublisher, Binding bindingType, int bookPages) {
        author = bookAuthor;
        title = bookTitle;
        publisher = bookPublisher;
        binding = bindingType;
        pages = bookPages;
        refNumber = "";
    }

    //getter methods

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getPublisher() {
        return publisher;
    }

    public Binding getBinding() {
        return binding;
    }

    public String getRefNumber() {
        return refNumber;
    }

    public int getPages() {
        return pages;
    }

    //setter methods

    public void setRefNumber(String refNumber) {
        if (refNumber.length()  < 3) {
            System.out.println("The reference number must " +
                    "be at least three characters");
        }
        else {
            this.refNumber = refNumber;
        }
    }

    //print methods

//    public void printAuthor() {
//        System.out.println(author);
//    }
//
//    public void printTitle() {
//        System.out.println(title);
//    }
//
//    public void printPublisher() {
//        System.out.println(publisher);
//    }
//
//    public void printBinding() {
//        System.out.println(binding.toString().toLowerCase());
//    }
//
//    public void printPages() {
//        System.out.println(pages);
//    }


    /*
    I used Refactor > Extract > Method to change from the
    old println statements I had here to methods and method calls.
     */
    public void printDetails() {
        printAuthor();
        printTitle();
        printPublisher();
        printBinding();
        printPages();
        printRefNumber();
    }

    public void printRefNumber() {
        if (refNumber.length() == 0) {
            System.out.println("Ref Number:\tZZZ");
        }
        else {
            System.out.println("Ref Number:\t" + refNumber);
        }
    }

    public void printPages() {
        System.out.println("Pages:\t\t" + getPages());
    }

    public void printBinding() {
        System.out.println("Binding:\t" + getBinding());
    }

    public void printPublisher() {
        System.out.println("Publisher:\t" + getPublisher());
    }

    public void printTitle() {
        System.out.println("Title:\t\t" + getTitle());
    }

    public void printAuthor() {
        System.out.println("Author:\t\t" + getAuthor());
    }

}