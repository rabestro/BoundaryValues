package lv.id.jc.boundaryvalues.case03;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class TimeUntilMidnightOriginal implements TimeUntilMidnight {

    @Override
    public String get() {
        var today = LocalDate.now();
        var now = LocalTime.now();

        var nowToday = LocalDateTime.of(today, now);
        var midnight = LocalDateTime.of(today, LocalTime.MAX);

        var hours = midnight.getHour() - nowToday.getHour();
        var minutes = midnight.getMinute() - nowToday.getMinute();
        var seconds = midnight.getSecond() - nowToday.getSecond();

        return formatMessage(hours, minutes, seconds);
    }
}
