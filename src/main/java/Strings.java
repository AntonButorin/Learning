import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Strings {

    protected String takeInitials(String fullName) {
        StringBuilder sb = new StringBuilder();
        Matcher matcher = Pattern.compile("[A-Z]").matcher(fullName);
        while (matcher.find()) {
            sb.append(matcher.group());
        }
        return sb.toString();
    }

    protected boolean areAnagrams(String text1, String text2) {
        Pattern pattern = Pattern.compile("[^a-zA-Z.?!,'\"\\s]");
        if (pattern.matcher(text1).find() || pattern.matcher(text2).find()) {
            throw new IllegalArgumentException("Text contains impossible characters.");
        }

        List<Character> chars1 = this.takeWordCharacters(text1)
                .chars()
                .mapToObj(e -> (char) e)
                .collect(Collectors.toList());
        List<Character> chars2 = this.takeWordCharacters(text2)
                .chars()
                .mapToObj(e -> (char) e)
                .collect(Collectors.toList());

        return chars1.containsAll(chars2);
    }

    protected String takeWordCharacters(String text) {
        StringBuilder sb = new StringBuilder();
        Matcher matcher = Pattern.compile("[a-zA-Z]").matcher(text);
        while (matcher.find()) {
            sb.append(matcher.group().toLowerCase());
        }
        return sb.toString();
    }
}

