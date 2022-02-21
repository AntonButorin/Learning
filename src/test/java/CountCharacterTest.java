import org.junit.*;
import static org.junit.Assert.*;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CountCharacterTest {

    @Before
    public void init() {
        String text = "In Xanadu did Kubla Khan\n" +
                "A stately pleasure-dome decree:\n" +
                "Where Alph, the sacred river, ran\n" +
                "Through caverns measureless to man\n" +
                "Down to a sunless sea.";
        try (PrintWriter printWriter = new PrintWriter(new FileWriter("xanadu.txt"))) {
            printWriter.print(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @After
    public void clear() throws IOException {
        Files.deleteIfExists(Paths.get("xanadu.txt"));
    }

    @Test
    public void checkCount() {
        assertEquals(18, new CountCharacter("e", "xanadu.txt").count());
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkMoreThanOneLetter() {
       new CountCharacter("egg", "xanadu.txt");
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkValidConsole() {
        String[] array = {"fgfg", "g"};
       CountCharacter.validConsole(array);
    }
}
