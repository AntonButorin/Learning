import java.util.Arrays;
import java.util.Locale;

public class Numbers {

    protected int takeSumOfInt(int... numbers) {
        int numArgs = 0;

        if (numbers != null) {
            numArgs = numbers.length;
        }
        if (numArgs < 2) {
            throw new IllegalArgumentException("Numbers of arguments is less than two.");
        }
        return Arrays.stream(numbers).sum();
    }

    protected String takeSumOfDouble(double... numbers) {
        double numArgs = 0;

        if (numbers != null) {
            numArgs = numbers.length;
        }
        if (numArgs < 2) {
            throw new IllegalArgumentException("Numbers of arguments is less than two.");
        }
        return String.format(Locale.GERMANY, "%.2f", Arrays.stream(numbers).sum());
    }
}

