/**
 * Created by Alex on 2/12/14.
 */
public class CodePlay {

    public static void main(String[] args){

        String textone = "Java";
        String texttwo = "Java";

        System.out.println("Same reference?");
        System.out.println(textone == texttwo);
        System.out.println("Same content?");
        System.out.println(textone.equals(texttwo));
    }
}
