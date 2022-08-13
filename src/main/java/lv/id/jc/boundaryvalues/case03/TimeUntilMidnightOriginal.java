package lv.id.jc.boundaryvalues.case03;

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class TimeUntilMidnightOriginal implements TimeUntilMidnight {
    private final Clock clock;

    public TimeUntilMidnightOriginal() {
        this(Clock.systemDefaultZone());
    }

    public TimeUntilMidnightOriginal(Clock clock) {
        this.clock = clock;
    }

    @Override
    public String get() {
        var today = LocalDate.now(clock);
        var now = LocalTime.now(clock);

        var nowToday = LocalDateTime.of(today, now);
        var midnight = LocalDateTime.of(today, LocalTime.MAX);

        var hours = midnight.getHour() - nowToday.getHour();
        var minutes = midnight.getMinute() - nowToday.getMinute();
        var seconds = midnight.getSecond() - nowToday.getSecond();

        return formatMessage(hours, minutes, seconds);
    }
}
