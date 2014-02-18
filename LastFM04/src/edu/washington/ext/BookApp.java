package edu.washington.ext;

/**
 * Created by Alex on 2/13/14.
 */
public class BookApp {

    private static String description = "";
    private static String wordToCount = "";
    private static Book testBook = null;

    public static void main(String[] args) {
        if (args.length <= 0) {
            System.out.println("No arguments supplied");
        }
        else {
            description = args[0];
        }
        if (args.length > 1) {
            wordToCount = args[1];
        }

        testBook = new Book("Cay Horstmann", "Core Java Vol 1, 9th Ed", description, "Prentice Hall",
                Binding.EPUB);

        // Printing
        testBook.printDetails();
        System.out.println("Description: " + testBook.getDescription());
        System.out.println("Number of words in description: " +
                testBook.getTotalWordsInDescription());
        System.out.println("Number of unique words in description: " +
                testBook.getTotalUniqueWordsInDescription());
        if (!wordToCount.isEmpty()) {
            System.out.println(countOfWord(wordToCount));
        }
    }

    // Count instances of a word if supplied as 2nd parameter
    private static String countOfWord(String wordToCount) {
        int wordCount = testBook.getTotalWordInDescription(wordToCount);
        String result = "The word \"" + wordToCount + "\" occurs " +
                wordCount + " time";
        if (wordCount != 1) {
            result = result + "s";
        }
        return result;
    }
}
