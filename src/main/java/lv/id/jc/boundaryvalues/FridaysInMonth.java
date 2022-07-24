package lv.id.jc.boundaryvalues;

import java.time.LocalDate;
import java.util.List;
import java.util.function.Function;

public interface FridaysInMonth extends Function<LocalDate, List<LocalDate>> {
}
