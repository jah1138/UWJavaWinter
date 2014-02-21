import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Alex on 2/20/14.
 */
public class Rot13Test {

    private static final String TEST_STRING = "Hello there. Testing, testing!";
    private static final String TEST_STRING_ANS = "Uryyb gurer. Grfgvat, grfgvat!";

    Rot13 encrypter;
    @Before
    public void setup() {
        encrypter = new Rot13();
    }

    /**
     * Tests the encrypt method.
     */
    @Test
    public void testEncrypt() {
        assertEquals(encrypter.encrypt(TEST_STRING), TEST_STRING);
        //assertEquals(encrypter.encrypt(TEST_STRING), TEST_STRING_ANS);
    }
}
