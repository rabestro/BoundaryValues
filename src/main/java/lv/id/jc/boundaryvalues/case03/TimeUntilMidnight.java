package lv.id.jc.boundaryvalues.case03;

import java.util.function.Supplier;

public interface TimeUntilMidnight extends Supplier<String> {

    default String formatMessage(long hours, long minutes, long seconds) {
        return "Hurry, sale ends at midnight, time left: %s hours, %s minutes, %s seconds"
                .formatted(hours, minutes, seconds);
    }
}
