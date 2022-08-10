package lv.id.jc.boundaryvalues.case02


import spock.lang.Narrative
import spock.lang.Specification
import spock.lang.Subject
import spock.lang.Title
import spock.lang.Unroll

import java.time.LocalDate

@Subject(FridaysInMonthOriginal)
@Title("All Fridays in the month (wrong)")
@Narrative('The wrong algorithm in "Java SE 17 Playbook" course')
class FridaysInMonthOriginalTest extends Specification {

    @Unroll('Today is #today; #comment')
    def 'should return all fridays in the month'() {
        given:
        def underTest = new FridaysInMonthOriginal()

        expect:
        underTest.apply(today) == fridays

        where:
        date         | days                | comment
        '2022-02-13' | [4, 11, 18, 25]     | 'Four fridays in February'
        '2008-02-21' | [1, 8, 15, 22, 29]  | 'Five Fridays in February'
        '2022-04-09' | [1, 8, 15, 22, 29]  | 'The Friday is the first day in April'
        '2021-12-31' | [3, 10, 17, 24, 31] | 'The Friday is the last day in December'
        '2022-06-17' | [3, 10, 17, 24]     | 'The last day is Thursday in June'

        and:
        today = LocalDate.parse(date)
        fridays = days.collect { today.withDayOfMonth(it) }
    }
}
