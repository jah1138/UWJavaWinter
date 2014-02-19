package edu.washington.ext;

import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.Set;

/**
 * A class that maintains information about a book.
 * This might form part of a larger application such
 * as a library system, for instance.
 *
 * @author Alex Harris
 * @version February 15, 2014
 */
public class Book {

    private String author = "";
    private String title = "";
    private String description = "";
    private String publisher = "";
    private Binding binding = null;
    private int pages = 0;
    private String refNumber = null;
    /**
     * A version of the book description prepared for the word counting
     * functions. All punctuation is removed and the text converted to
     * lower case. The original description remains unchanged.
     */
    protected String sanitizedDescription = "";


    /**
     * Creates a book with generic default values supplied as the parameters.<br>
     *<br>
     * author = "Author"<br>
     * title = "Title"<br>
     * description = "Description"<br>
     * publisher = "Publisher"<br>
     * binding = null
     */
    Book(){
        this("Author", "Title", "Description", "Publisher", null);
    }

    /**
     * Creates a book with details passed in as parameters:
     *
     * @param author Book author.
     * @param title Book title.
     * @param description Book description.
     * @param publisher Book publisher.
     * @param binding Binding style of book.
     */
    Book(String author, String title, String description, String publisher, Binding binding) {
        this.author = author;
        this.title = title;
        this.description = description;
        this.publisher = publisher;
        this.binding = binding;
        this.pages = 0;
        refNumber = "";
        /**
         * This is a version of the book description which has been prepared for
         * the word count methods. All punctuation has been removed and the text
         * has been set to lower case. The original book description is unchanged.
         */
        sanitizedDescription = description.replaceAll("[?:!.,;]*", "").toLowerCase();
    }

    //getter methods

    /**
     *Returns the book author.
     *
     * @return the author.
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Returns the book title.
     *
     * @return the title.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Returns the book description.
     *
     * @return the description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns the book publisher.
     *
     * @return the publisher.
     */
    public String getPublisher() {
        return publisher;
    }

    /**
     * Returns the book binding type. This can include
     * e-book formats.
     *
     * @return book binding.
     */
    public Binding getBinding() {
        return binding;
    }

    /**
     * Returns the book reference number.
     *
     * @return book reference.
     */
    public String getRefNumber() {
        return refNumber;
    }

    /**
     * Returns the number of pages in the book.
     *
     * @return number of pages.
     */
    public int getPages() {
        return pages;
    }

    //setter methods

    /**
     * Sets the description of the book, replacing any existing
     * description.
     *
     * @param description A description of the book.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Sets the reference number of the book, replacing any existing
     * reference number. The number must contain at least three characters.
     *
     * @param refNumber Reference number of the book.
     */
    public void setRefNumber(String refNumber) {
        if (refNumber.length()  < 3) {
            System.out.println("The reference number must " +
                    "be at least three characters");
        }
        else {
            this.refNumber = refNumber;
        }
    }

    //working methods

    /**
     * Returns the total number of words in the book description.
     *
     * @return Number of words in the description.
     */
    public int getTotalWordsInDescription() {
        StringTokenizer st = new StringTokenizer(sanitizedDescription);
        return st.countTokens();
    }

    /**
     * Returns the number of times a word appears in the book description.
     * Case insensitive.
     *
     * @param word The word to count.
     * @return The number of times the word is used.
     */
    public int getTotalWordInDescription(String word) {
        System.out.println("Sanitized description: " + sanitizedDescription); //debug
        StringTokenizer st = new StringTokenizer(sanitizedDescription);
        int wordCount = 0;
        while (st.hasMoreTokens()) {
            if (st.nextToken().equals(word)) {
                wordCount++;
            }
        }
        return wordCount;
    }

    /**
     * Counts the number of unique words in the book description.
     *
     * @return Number of unique words in the description.
     */
    public int getTotalUniqueWordsInDescription() {
        Set<String> wordSet = new HashSet<String>();
        StringTokenizer st = new StringTokenizer(sanitizedDescription);
        while (st.hasMoreTokens()) {
            wordSet.add(st.nextToken());
        }
        return wordSet.size();
    }

    //print methods

    /**
     * Prints complete details about the book.
     * Includes:
     *   Author
     *   Title
     *   Publisher
     *   Binding
     *   Pages
     */
    public void printDetails() {
        printAuthor();
        printTitle();
        printPublisher();
        printBinding();
        printPages();
        //printRefNumber();
    }

    /**
     * Prints the reference number of the book. If the book does
     * not have a reference number, prints "ZZZ".
     */
    public void printRefNumber() {
        if (refNumber.length() == 0) {
            System.out.println("Ref Number:\tZZZ");
        }
        else {
            System.out.println("Ref Number:\t" + refNumber);
        }
    }

    /**
     * Prints the number of pages in the book.
     */
    public void printPages() {
        System.out.println("Pages:\t\t" + getPages());
    }

    /**
     * Prints the binding type of the book.
     */
    public void printBinding() {
        System.out.println("edu.washington.ext.Binding:\t" + getBinding());
    }

    /**
     * Prints the publisher of the book.
     */
    public void printPublisher() {
        System.out.println("Publisher:\t" + getPublisher());
    }

    /**
     * Prints the title of the book.
     */
    public void printTitle() {
        System.out.println("Title:\t\t" + getTitle());
    }

    /**
     * Prints the author of the book.
     */
    public void printAuthor() {
        System.out.println("Author:\t\t" + getAuthor());
    }

}