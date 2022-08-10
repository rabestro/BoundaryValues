package lv.id.jc.boundaryvalues.case02;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);

        var date = LocalDate.parse(scanner.nextLine());

        var start = date.with(TemporalAdjusters.firstDayOfMonth());
        var stop = date.with(TemporalAdjusters.lastDayOfMonth());
        var firstFriday = start.with(TemporalAdjusters.nextOrSame(DayOfWeek.FRIDAY));
        var fridays = new ArrayList<LocalDate>();

        while (firstFriday.isBefore(stop)) {
            fridays.add(firstFriday);
            firstFriday = firstFriday.plusWeeks(1);
        }

        System.out.println("Fridays in the month: " + fridays);
    }
}
