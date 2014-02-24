package edu.washington.midcourse;
import edu.washington.midcourse.util.Rot13;

/**
 * Class which encrypts a string using Rot13 encryption.
 *
 * @author Alex Harris
 * @version February 21, 2014
 */
public class Main {

    /**
     * Takes a string argument (enclosed in quotes) and prints out the encrypted result.
     * @param args
     */
    public static void main(String[] args) {

        if (args.length != 1) {
            System.err.println("one string argument required");
        }
        else {
            Rot13 encrypter = new Rot13();
            System.out.println(encrypter.encrypt(args[0]));
        }
    }
}
