package edu.washington.ext;

/**
 * <p>A class which creates a book and performs two operations.</p>
 *
 * <p>When this class is invoked at the command line it takes one or two parameters:</p>
 *
 * <p>1. The first parameter is a book description string, which must be
 * enclosed in quotes. This parameter is required.</p>
 *
 * <p>2. The second parameter is optional. A word can be entered following
 * the description string, and the application will count how many
 * times the word appears in the description. (Case insensitive.)</p>
 *
 * <p>The results of the two operations are printed to the console.</p>
 *
 * @author Alex Harris
 * @version February 15, 2014
 */
public class BookApp {

    private static String description = "";
    private static String wordToCount = "";
    private static Book testBook = null;

    public static void main(String[] args) {
        if (args.length <= 0) {
            System.out.println("No arguments supplied");
            System.exit(0);
        }
        else {
            description = args[0];
        }
        if (args.length > 1) {
            wordToCount = args[1];
            wordToCount = wordToCount.toLowerCase();
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
