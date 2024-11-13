package collections_chapter;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class RandomPrintingTest {

    @Test
    public void checkNumberOfPrintingLines() throws IOException {
        RandomPrinting randomPrinting = new RandomPrinting("src/test/resources/test.txt");
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        randomPrinting.printRandomLines(3);
        assertEquals(3, outContent.toString().lines().count());
    }

    @Test
    public void checkThatLinesAreRandom() throws IOException {
        RandomPrinting randomPrinting = new RandomPrinting("src/test/resources/test.txt");
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        randomPrinting.printRandomLines(10);
        assertTrue(outContent.toString().lines().collect(Collectors.toSet()).size() > 1);
    }
}
