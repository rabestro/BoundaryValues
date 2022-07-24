package lv.id.jc.boundaryvalues

import spock.lang.Narrative
import spock.lang.Specification
import spock.lang.Subject
import spock.lang.Title
import spock.lang.Unroll

import java.time.LocalDate

@Subject(FridaysInMonthCorrect)
@Title("All Fridays in the month (correct)")
@Narrative('The correct algorithm to find all fridays in the month')
class FridaysInMonthCorrectTest extends Specification {

    @Unroll('Today is #today; #comment')
    def 'should return all fridays in the month'() {
        given:
        def underTest = new FridaysInMonthCorrect()

        expect:
        underTest.apply(today) == fridays

        where:
        date         | days                | comment
        '2022-02-13' | [4, 11, 18, 25]     | 'Four Fridays in February'
        '2008-02-21' | [1, 8, 15, 22, 29]  | 'Five Fridays in February'
        '2022-06-17' | [3, 10, 17, 24]     | 'The last day is Thursday in June'
        '2022-04-09' | [1, 8, 15, 22, 29]  | 'The Friday is the first day in April'
        '2021-12-31' | [3, 10, 17, 24, 31] | 'The Friday is the last day in December'

        and:
        today = LocalDate.parse(date)
        fridays = days.collect { today.withDayOfMonth(it) }
    }
}
