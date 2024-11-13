package collections_chapter;

import java.util.*;

public class PrintArgumentInRandomOrder {

    public void printWithStream(List<String> list) {
        Collections.shuffle(list);
        list.forEach(System.out::println);
    }

    public void printWithTraditionalForEach(List<String> list) {
        Collections.shuffle(list);
        for (String arg : list) {
            System.out.println(arg);
        }
    }
}
