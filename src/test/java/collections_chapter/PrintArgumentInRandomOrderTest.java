package collections_chapter;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertNotEquals;

public class PrintArgumentInRandomOrderTest {

    @Test
    public void checkPrintWithTraditionalForEach(){
        List<String> list = Arrays.asList("1", "2", "3", "4", "5");
        PrintArgumentInRandomOrder print = new PrintArgumentInRandomOrder();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();

        System.setOut(new PrintStream(outContent));
        print.printWithTraditionalForEach(list);

        assertNotEquals(list.toString(), outContent.toString());
    }

    @Test
    public void checkPrintWithStream(){
        List<String> list = Arrays.asList("1", "2", "3", "4", "5");
        PrintArgumentInRandomOrder print = new PrintArgumentInRandomOrder();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();

        System.setOut(new PrintStream(outContent));
        print.printWithStream(list);

        assertNotEquals(list.toString(), outContent.toString());
    }
}
