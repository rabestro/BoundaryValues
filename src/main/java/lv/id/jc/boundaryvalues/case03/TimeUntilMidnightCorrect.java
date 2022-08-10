package lv.id.jc.boundaryvalues.case03;

import java.time.Clock;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class TimeUntilMidnightCorrect implements TimeUntilMidnight {

    private static final long SECONDS_IN_MINUTE = 60;
    private static final long SECONDS_IN_HOUR = SECONDS_IN_MINUTE * 60;

    private final Clock clock;

    public TimeUntilMidnightCorrect() {
        this(Clock.systemDefaultZone());
    }

    public TimeUntilMidnightCorrect(Clock clock) {
        this.clock = clock;
    }


    @Override
    public String get() {
        var now = LocalDateTime.now(clock);

        var midnight = LocalDateTime.of(now.toLocalDate().plusDays(1), LocalTime.MIDNIGHT);

        var duration = Duration.between(now, midnight);

        var seconds = duration.getSeconds();
        var hours = seconds / SECONDS_IN_HOUR;
        seconds -= hours * SECONDS_IN_HOUR;
        var minutes = seconds / SECONDS_IN_MINUTE;
        seconds -= minutes * SECONDS_IN_MINUTE;

        return formatMessage(hours, minutes, seconds);
    }
}
