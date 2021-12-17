import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CharSequenceClassTest {

    private CharSequenceClass csc;

    @Before
    public void init() {
        csc = new CharSequenceClass("Text for test.");
    }

    @Test
    public void checkLength() {
        Assert.assertEquals(14, csc.length());
    }

    @Test
    public void checkCharAt() {
        Assert.assertEquals('x', csc.charAt(11));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void checkCharAtWithInvalidIndex() {
        csc.charAt(25);
    }

    @Test
    public void checkSubSequence() {
        Assert.assertEquals("set rof", csc.subSequence(2, 8));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void checkSubSequenceWithInvalidIndex() {
        csc.subSequence(1, 25);
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkSubSequenceWithEndLessStart() {
        csc.subSequence(10, 2);
    }

    @Test
    public void checkToString() {
        Assert.assertEquals(".tset rof txeT", csc.toString());
    }
}
