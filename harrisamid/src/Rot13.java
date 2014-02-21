/**
 * Created by Alex on 2/20/14.
 */
public class Rot13 {

    private String stringToEncrypt = null;
    private String encryptedString = null;
    private char[] encrypted = null;

    Rot13() {
    }

    public String encrypt(String stringToEncrypt){
        encrypted = new char[stringToEncrypt.length()];
        for (int i = 0; i < stringToEncrypt.length(); i++) {
            encrypted[i] = stringToEncrypt.charAt(i);
        }
        encryptedString = new String(encrypted);
        return encryptedString;
    }
}


