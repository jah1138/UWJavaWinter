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
    protected String sanitizedDescription = "";

    Book(){
        this("Author", "Title", "Description", "Publisher", null);
    }

    Book(String author, String title, String description, String publisher, Binding binding) {
        this.author = author;
        this.title = title;
        this.description = description;
        this.publisher = publisher;
        this.binding = binding;
        this.pages = 0;
        refNumber = "";
        sanitizedDescription = description.replaceAll("[?:!.,;]*", "").toLowerCase();
    }

    //getter methods

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
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

    public void setDescription(String description) {
        this.description = description;
    }

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

    public int getTotalWordsInDescription() {
        StringTokenizer st = new StringTokenizer(sanitizedDescription);
        return st.countTokens();
    }

    public int getTotalWordInDescription(String word) {
        StringTokenizer st = new StringTokenizer(sanitizedDescription);
        int wordCount = 0;
        while (st.hasMoreTokens()) {
            if (st.nextToken().equals(word)) {
                wordCount++;
            }
        }
        return wordCount;
    }

    public int getTotalUniqueWordsInDescription() {
        Set<String> wordSet = new HashSet<String>();
        StringTokenizer st = new StringTokenizer(sanitizedDescription);
        while (st.hasMoreTokens()) {
            wordSet.add(st.nextToken());
        }
        return wordSet.size();
    }

    //print methods

    public void printDetails() {
        printAuthor();
        printTitle();
        printPublisher();
        printBinding();
        printPages();
        //printRefNumber();
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
        System.out.println("edu.washington.ext.Binding:\t" + getBinding());
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