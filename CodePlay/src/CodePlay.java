import java.lang.reflect.Array;

/**
 * Created by Alex on 2/12/14.
 */
public class CodePlay {

    public static void main(String[] args){

        // test whether array length methods count empty strings
        String[] testArray = {"foo", "bar", ""};
        System.out.println("testArray.length is " + testArray.length);
        System.out.println("Array.getLength(testArray) is " + Array.getLength(testArray));

//        // test the constant pool thing
//        String textone = "Java";
//        String texttwo = "Java";
//
//        System.out.println("Same reference?");
//        System.out.println(textone == texttwo);
//        System.out.println("Same content?");
//        System.out.println(textone.equals(texttwo));


    }
}
