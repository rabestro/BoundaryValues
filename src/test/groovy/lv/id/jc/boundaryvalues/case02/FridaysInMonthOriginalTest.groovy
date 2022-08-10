package lv.id.jc.boundaryvalues.case02

import spock.lang.Narrative
import spock.lang.Specification
import spock.lang.Subject
import spock.lang.Title

import java.time.LocalDate

@Subject(FridaysInMonthOriginal)
@Title("All Fridays in the month (wrong)")
@Narrative('The wrong algorithm in "Java SE 17 Playbook" course')
class FridaysInMonthOriginalTest extends Specification {

    def 'should return all fridays in the month'() {
        given:
        def underTest = new FridaysInMonthOriginal()

        expect:
        underTest.apply(today) == fridays

        where:
        date         | days
        '2022-02-13' | [4, 11, 18, 25]
        '2022-04-09' | [1, 8, 15, 22, 29]
        '2022-06-17' | [3, 10, 17, 24]

        and:
        today = LocalDate.parse(date)
        fridays = days.collect { today.withDayOfMonth(it) }
    }
}
