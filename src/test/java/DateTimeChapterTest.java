import org.junit.Test;

import java.time.Month;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DateTimeChapterTest {

    @Test
    public void checkTakingLengthOfMonths() {
        DateTimeChapter dateTimeChapter = new DateTimeChapter();
        Map<Month, Integer> map = new HashMap<>();
        map.put(Month.JANUARY, 31);
        map.put(Month.FEBRUARY, 29);
        map.put(Month.MARCH, 31);
        map.put(Month.APRIL, 30);
        map.put(Month.MAY, 31);
        map.put(Month.JUNE, 30);
        map.put(Month.JULY, 31);
        map.put(Month.AUGUST, 31);
        map.put(Month.SEPTEMBER, 30);
        map.put(Month.OCTOBER, 31);
        map.put(Month.NOVEMBER, 30);
        map.put(Month.DECEMBER, 31);
        assertEquals(map, dateTimeChapter.takeLengthOfMonths(2024));
    }

    @Test
    public void checkThatDateIsFridayThirteen() {
        DateTimeChapter dateTimeChapter = new DateTimeChapter();
        assertTrue(dateTimeChapter.isDateFridayThirteenth(2024, Month.DECEMBER, 13));
    }
}
