package lv.id.jc.boundaryvalues.case03

import spock.lang.Specification
import spock.lang.Unroll

import java.time.Clock
import java.time.LocalDateTime
import java.time.ZoneId

class TimeUntilMidnightCorrectTest extends Specification {

    @Unroll("at #time remains #hours hours, #minutes minutes and #seconds seconds until midnight")
    def 'should return correct message for an ordinary day'() {
        given:
        def underTest = new TimeUntilMidnightCorrect(clock)

        when:
        def message = underTest.get()

        then:
        message == expected

        where: 'we set the timezone to Italian time'
        zone = ZoneId.of('Europe/Rome')

        and: 'In Italy, 20 March 2018 is an ordinary day containing 24 hours'
        date         | time       || hours | minutes | seconds
        '2018-03-20' | '00:00:00' || 24    | 0       | 0
        '2018-03-20' | '00:00:01' || 23    | 59      | 59
        '2018-03-20' | '00:01:00' || 23    | 59      | 0
        '2018-03-20' | '01:00:00' || 23    | 0       | 0
        '2018-03-20' | '02:00:00' || 22    | 0       | 0
        '2018-03-20' | '02:00:01' || 21    | 59      | 59
        '2018-03-20' | '02:00:02' || 21    | 59      | 58
        '2018-03-20' | '02:00:10' || 21    | 59      | 50
        '2018-03-20' | '02:01:00' || 21    | 59      | 00
        '2018-03-20' | '02:10:00' || 21    | 50      | 00
        '2018-03-20' | '02:59:59' || 21    | 0       | 1
        '2018-03-20' | '03:00:00' || 21    | 0       | 0
        '2018-03-20' | '03:00:01' || 20    | 59      | 59

        and: 'we fix the system time'
        now = LocalDateTime.parse(date + 'T' + time).atZone(zone).toInstant()
        clock = Clock.fixed(now, zone)

        and: 'expected message about the amount of time left until midnight'
        expected = "Hurry, sale ends at midnight, time left: $hours hours, $minutes minutes, $seconds seconds"
    }

    @Unroll("at #time remains #hours hours, #minutes minutes and #seconds seconds until midnight")
    def 'should return correct message for the day on which daylight saving time occurs'() {
        given:
        def underTest = new TimeUntilMidnightCorrect(clock)

        when:
        def message = underTest.get()

        then:
        message == expected

        where: 'In Italy, 25 March 2018 is the day on which daylight saving time occurs'
        date         | time       || hours | minutes | seconds
        '2018-03-25' | '00:00:00' || 23    | 0       | 0
        '2018-03-25' | '00:00:01' || 22    | 59      | 59
        '2018-03-25' | '00:59:59' || 22    | 0       | 1
        '2018-03-25' | '00:01:00' || 22    | 59      | 0
        '2018-03-25' | '01:00:00' || 22    | 0       | 0
        '2018-03-25' | '01:00:01' || 21    | 59      | 59
        '2018-03-25' | '02:00:00' || 21    | 0       | 0
        '2018-03-25' | '02:00:01' || 20    | 59      | 59
        '2018-03-25' | '03:00:00' || 21    | 0       | 0
        '2018-03-25' | '03:00:01' || 20    | 59      | 59
        '2018-03-25' | '23:00:00' || 1     | 0       | 0
        '2018-03-25' | '23:59:59' || 0     | 0       | 1
        '2018-03-25' | '23:59:00' || 0     | 1       | 0

        and: 'we fix the system time'
        zone = ZoneId.of('Europe/Rome')
        now = LocalDateTime.parse(date + 'T' + time).atZone(zone).toInstant()
        clock = Clock.fixed(now, zone)

        and: 'expected message about the amount of time left until midnight'
        expected = "Hurry, sale ends at midnight, time left: $hours hours, $minutes minutes, $seconds seconds"
    }

}
