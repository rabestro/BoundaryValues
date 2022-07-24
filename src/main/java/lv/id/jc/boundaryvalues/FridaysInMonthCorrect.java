package lv.id.jc.boundaryvalues;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.List;
import java.util.stream.Stream;

public class FridaysInMonthCorrect implements FridaysInMonth {

    @Override
    public List<LocalDate> apply(LocalDate date) {

        return Stream.iterate(
                date.with(TemporalAdjusters.firstInMonth(DayOfWeek.FRIDAY)),
                friday -> friday.getMonth().equals(date.getMonth()),
                friday -> friday.with(TemporalAdjusters.next(DayOfWeek.FRIDAY))
        ).toList();
    }
}
