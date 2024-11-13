import java.time.*;
import java.time.temporal.TemporalAdjusters;
import java.util.*;

public class DateTimeChapter {

    public Map<Month, Integer> takeLengthOfMonths(int year) {
        Map<Month, Integer> map = new HashMap<>();
            for (Month month : Month.values()) {
                map.put(month, YearMonth.of(year, month).lengthOfMonth());
            }
        return map;
    }

    public List<LocalDate> takeMondaysInMonth(Month month) {
        List<LocalDate> list = new ArrayList<>();
        LocalDate date = Year.now().atMonth(month).atDay(1)
                .with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));
        while (month == date.getMonth()) {
            list.add(date);
            date = date.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
        }
        return list;
    }

    public boolean isDateFridayThirteenth(int year, Month month, int day) {
        LocalDate date = LocalDate.of(year, month, day);
        return date.getDayOfMonth() == 13 && date.getDayOfWeek() == DayOfWeek.FRIDAY;
    }
}