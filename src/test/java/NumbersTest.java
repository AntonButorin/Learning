import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NumbersTest {

    private Numbers numbers;

    @Before
    public void init() {
        numbers = new Numbers();
    }

    @Test
    public void checkTakeSumOfInt() {
        int[] num = {1, 3, 2, 10};

        assertEquals(16, numbers.takeSumOfInt(num));
    }

    @Test
    public void checkTakeSumOfDouble() {
        double[] num = {1, 1e2, 3.0, 4.754};

        assertEquals("108,75", numbers.takeSumOfDouble(num));
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkTakeSumOfDoubleWithOneArg() {
        double[] num = {1};

        numbers.takeSumOfDouble(num);
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkTakeSumOfIntWithOneArg() {
        int[] num = {1};

        numbers.takeSumOfInt(num);
    }
}

