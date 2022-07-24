package lv.id.jc.boundaryvalues;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;

public class FridaysInMonthWrong implements FridaysInMonth {
    @Override
    public List<LocalDate> apply(LocalDate date) {
        var start = date.with(TemporalAdjusters.firstDayOfMonth());
        var stop = date.with(TemporalAdjusters.lastDayOfMonth());
        var firstFriday = start.with(TemporalAdjusters.nextOrSame(DayOfWeek.FRIDAY));
        var fridays = new ArrayList<LocalDate>();

        while (firstFriday.isBefore(stop)) {
            fridays.add(firstFriday);
            firstFriday = firstFriday.plusWeeks(1);
        }
        return fridays;
    }
}
