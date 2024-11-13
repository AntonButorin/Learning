package collections_chapter;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class ToeFactoryTest {
    String[] names = {"Robert A", "John K", "Patrik C", "John D", "Robert G", "Robert T"};

    @Test
    public void checkTakeToeReceiver() {
        boolean isFailed = true;
        ToeFactory toeFactory = new ToeFactory();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            set.add(toeFactory.takeToeReceiver(names));
            if (set.size() > 1) {
                isFailed = false;
                break;
            }
        }
        assertFalse(isFailed);
    }

    @Test
    public void checkTakeUniqueFirstNames() {
        ToeFactory toeFactory = new ToeFactory();
        Set<String> set = new HashSet<>(Arrays.asList("Patrik", "Robert", "John"));
        assertEquals(set, toeFactory.takeUniqueFirstNames(names));
    }

    @Test
    public void checkTakeNameCount() {
        ToeFactory toeFactory = new ToeFactory();
        Map<String, Long> map = new HashMap<>();
        map.put("John", 2L);
        map.put("Patrik", 1L);
        map.put("Robert", 3L);
        assertEquals(map, toeFactory.takeNameCount(names));
    }

    @Test
    public void checkTakeQueueOfEmployee() {
        ToeFactory toeFactory = new ToeFactory();
        Queue<String> queue = new LinkedList<>(Arrays.asList(names));
        assertEquals(queue, toeFactory.takeQueueOfEmployee(names));
    }
}
