package collections_chapter;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FindDupsTest {

    @Test
    public void checkPrintDistinctWords() {
        String[] words = {"Red", "red", "RED", "Blue", "black", "blue", "BLUE", "black", "BLACK", "blaCK", "BLACK"};
        String[] expWords = {"black", "Blue", "Red"};
        FindDups findDups = new FindDups();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();

        System.setOut(new PrintStream(outContent));
        findDups.printDistinctWords(words);
        assertEquals(expWords.length + " distinct words: " + Arrays.toString(expWords) + System.lineSeparator(),
                outContent.toString());
    }

    @Test
    public void checkTakeTrimList() {
        List<String> list =Arrays.asList(" red ", " blue ", " orange", "   purple red   ");
        FindDups findDups = new FindDups();
        List<String> expList = Arrays.asList("red", "blue", "orange", "purple red");

        assertEquals(expList, findDups.takeTrimList(list));
    }
}
