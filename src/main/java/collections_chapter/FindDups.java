package collections_chapter;

import java.util.*;
import java.util.stream.Collectors;

public class FindDups {

    private static final Comparator<String> IGNORE_CASE = String::compareToIgnoreCase;

    public List<String> takeTrimList(List<String> list) {
        return list.stream().map(String::trim).collect(Collectors.toList());
    }

    public void printDistinctWords(String[] args) {
        SortedSet<String> s = new TreeSet<>(IGNORE_CASE);
        Collections.addAll(s, args);
        System.out.println(s.size() + " distinct words: " + s);
    }
}