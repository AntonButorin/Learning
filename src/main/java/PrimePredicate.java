import java.math.BigInteger;
import java.util.List;
import java.util.function.Predicate;

public class PrimePredicate implements Predicate<Integer> {
    private List<Integer> list;

    public PrimePredicate(List<Integer> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("List is empty");
        }
        this.list = list;
    }

    public boolean test(Integer num) {
        for (Integer i : list) {
            if (i == null) {
                continue;
            }
            if (BigInteger.valueOf(i).gcd(BigInteger.valueOf(num)).intValue() != 1) {
                return false;
            }
        }
        return true;
    }
}
