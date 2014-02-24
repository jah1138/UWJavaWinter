import java.lang.reflect.Array;
import static java.util.Arrays.asList;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex on 2/12/14.
 */
public class CodePlay {

    public static void main(String[] args){

//        // test whether array length methods count empty strings
//        String[] testArray = {"foo", "bar", ""};
//        System.out.println("testArray.length is " + testArray.length);
//        System.out.println("Array.getLength(testArray) is " + Array.getLength(testArray));

//        // test the constant pool thing
//        String textone = "Java";
//        String texttwo = "Java";
//
//        System.out.println("Same reference?");
//        System.out.println(textone == texttwo);
//        System.out.println("Same content?");
//        System.out.println(textone.equals(texttwo));

        // test finding primitive char in ArrayList<Character>
        List<Integer> ASCII_65_77 = asList(65,66,67,68,69,70,71,72,73,74,75,76,77);
        List<Integer> ASCII_78_90 = asList(78,79,80,81,82,83,84,85,86,87,88,89,90);
        List<Integer> ASCII_97_109 = asList(97,98,99,100,101,102,103,104,105,106,107,108,109);
        List<Integer> ASCII_110_122 = asList(110,111,112,113,114,115,116,117,118,119,120,121,122);
        Character thisChar = new Character('A');
        System.out.println("thisChar = " + thisChar);
        System.out.println("(int)thisChar = " + (int)thisChar);
        System.out.println("ASCII_65_77.contains(thisChar)? " + ASCII_65_77.contains(thisChar));
        System.out.println("ASCII_65_77.contains((Integer)thisChar)? " + ASCII_65_77.contains((int)thisChar));


    }
}
