import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class DataStructureTest {

    @Test
    public void checkGetSize() {
        DataStructure ds = new DataStructure();
        Assert.assertEquals(15, ds.getSIZE());
    }

    @Test
    public void checkGetArray() {
        int[] expectedArray = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
        Assert.assertArrayEquals(expectedArray, new DataStructure().getArrayOfInts());
    }

    @Test
    public void checkGetEvenIterator() {
        Assert.assertNotNull(new DataStructure().getEvenIterator());
    }

    @Test
    public void checkPrintEven() {
        String expectedArray = "0 2 4 6 8 10 12 14 " + System.lineSeparator();
        DataStructure ds = new DataStructure();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();

        System.setOut(new PrintStream(outContent));
        ds.printEven();
        Assert.assertEquals(expectedArray, outContent.toString());
    }

    @Test
    public void checkIsEvenIndex() {
        Assert.assertTrue(DataStructure.isEvenIndex(2));
        Assert.assertFalse(DataStructure.isEvenIndex(1));
    }

    @Test
    public void checkIsOddIndex() {
        Assert.assertTrue(DataStructure.isOddIndex(1));
        Assert.assertFalse(DataStructure.isOddIndex(0));
    }

    @Test
    public void checkPrintWithIterator() {
        String expectedArray = "0 2 4 6 8 10 12 14 " + System.lineSeparator();
        DataStructure ds = new DataStructure();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();

        System.setOut(new PrintStream(outContent));
        ds.print(ds.getEvenIterator());
        Assert.assertEquals(expectedArray, outContent.toString());
    }

    @Test
    public void checkPrintWithFunction() {
        String expectedArray = "0 2 4 6 8 10 12 14 " + System.lineSeparator();
        DataStructure ds = new DataStructure();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();

        System.setOut(new PrintStream(outContent));
        ds.print(p -> p % 2 == 0);
        Assert.assertEquals(expectedArray, outContent.toString());
    }
}
