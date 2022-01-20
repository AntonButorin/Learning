import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

public class Generics {

    private Generics() {}

    protected static <T> int countElements(Collection<T> list, Predicate<T> predicate) {
        int counter = 0;

        if (list.isEmpty()) {
            throw new IllegalArgumentException("invalid list");
        }
        for (T t : list) {
            if (t != null && predicate.test(t)) {
                counter++;
            }
        }
        return counter;
    }

    protected static <T> T[] exchangeElements(T[] array, int index1, int index2) {
        if (array.length == 0) {
            throw new IllegalArgumentException("invalid array");
        }
        if (index1 < 0 || index2 > array.length - 1) {
            throw new IllegalArgumentException("invalid indexes");
        }
        T elem2 = array[index2];
        array[index2] = array[index1];
        array[index1] = elem2;
        return array;
    }

    protected static <T extends Object & Comparable<T>> T findMax(List<T> list, int begin, int end) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("Invalid list");
        }
        if (begin > end) {
            throw new IllegalArgumentException("begin > end");
        }
        if (begin < 0 || end > list.size() - 1) {
            throw new IllegalArgumentException("invalid params");
        }
        T max = list.get(begin);
        for (int i = begin + 1; i <= end; i++) {
            if ((max.compareTo(list.get(i)) < 0)) {
                max = list.get(i);
            }
        }
        return max;
    }

    public static <T> int findFirst(List<T> list, int begin, int end, Predicate<T> p) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("invalid list");
        }
        if (begin > end) {
            throw new IllegalArgumentException("begin > end");
        }
        if (begin < 0 || end > list.size() - 1) {
            throw new IllegalArgumentException("invalid params");
        }
        for (int i = begin; i <= end; i++) {
            if (list.get(i) == null) {
                continue;
            }
            if (p.test(list.get(i))) {
                return i;
            }
        }
        return -1;
    }
}
