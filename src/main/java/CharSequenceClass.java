import java.util.List;
import java.util.stream.Collectors;

public class CharSequenceClass implements CharSequence {

    private List<Character> charSequence;

    private CharSequenceClass() {
    }

    public CharSequenceClass(String text) {
        charSequence = new StringBuilder(text).reverse()
                .chars()
                .mapToObj(e -> (char) e)
                .collect(Collectors.toList());
    }

    @Override
    public int length() {
        return charSequence.size();
    }

    @Override
    public char charAt(int i) {
        return charSequence.get(i);
    }

    @Override
    public CharSequence subSequence(int i, int i1) {
        if (i > i1) {
            throw new IllegalArgumentException("start > end");
        }
        StringBuilder sb = new StringBuilder();
        for (int j = i; j <= i1; j++) {
            sb.append(charSequence.get(j));
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        charSequence.forEach(sb::append);
        return sb.toString();
    }
}
