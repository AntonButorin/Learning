import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StringsTest {

    private Strings strings;

    @Before
    public void init() {
        strings = new Strings();
    }

    @Test
    public void checkTakeInitials() {
        String text = "Jerome K. Jerome";

        assertEquals("JKJ", strings.takeInitials(text));
    }

    @Test
    public void checkAreAnagrams() {
        String text1 = "parliament";
        String text2 = "partial men";

        assertTrue(strings.areAnagrams(text1, text2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkAreAnagramsWithIncorrectArgs() {
        String text1 = "parliament^";
        String text2 = "partial men";

        strings.areAnagrams(text1, text2);
    }
}
