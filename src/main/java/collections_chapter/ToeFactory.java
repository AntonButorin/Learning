package collections_chapter;

import java.util.*;
import java.util.stream.Collectors;

public class ToeFactory {

    public String takeToeReceiver(String[] fullName) {
        List<String> employees = new ArrayList<>();
        Collections.addAll(employees, fullName);
        Collections.shuffle(employees);
        return employees.getFirst();
    }

    public Set<String> takeUniqueFirstNames(String[] fullName) {
        return Arrays.stream(fullName)
                .map(e -> e.split(" ")[0])
                .collect(Collectors.toSet());
    }

    public Map<String, Long> takeNameCount(String[] fullName) {
        return Arrays.stream(fullName)
                .collect(Collectors.groupingBy(e->e.split(" ")[0],
                        Collectors.counting()));
    }

    public Queue<String> takeQueueOfEmployee(String[] fullName) {
        Queue<String> queue = new LinkedList<>();
        Collections.addAll(queue, fullName);
        return queue;
    }
}
