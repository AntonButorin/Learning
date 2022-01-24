import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ListOfNumbersTest {

    ListOfNumbers list;

    @Before
    public void init() {
        list = new ListOfNumbers();
        List<Object> list1 = Arrays.asList(4, "frfrf", 4f, 88, "ddd4eee");
        try (PrintWriter printWriter = new PrintWriter(new FileWriter("InFile.txt"))) {
            list1.forEach(printWriter::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @After
    public void clear() {
        File file = new File("InFile.txt");
        File file2 = new File("OutFile.txt");
        if (file.exists()) {
            file.delete();
        }
        if (file2.exists()) {
            file2.delete();
        }

    }

    @Test
    public void checkReadList() {
        list.readList("InFile.txt");
        assertEquals(Arrays.asList(4, 88), list.getVector());
    }

    @Test
    public void checkWriteList() {
        ListOfNumbers list2 = new ListOfNumbers();
        list.readList("InFile.txt");
        list.writeList();
        list2.readList("OutFile.txt");
        assertTrue(list2.getVector().containsAll(list.getVector()));
    }
}
