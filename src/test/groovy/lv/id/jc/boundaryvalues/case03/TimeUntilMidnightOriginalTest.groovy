package lv.id.jc.boundaryvalues.case03

import spock.lang.Specification

import java.time.Clock
import java.time.LocalDateTime
import java.time.ZoneId

class TimeUntilMidnightOriginalTest extends Specification {
    def 'should return correct message for time zone'() {
        given:
        def underTest = new TimeUntilMidnightOriginal(clock)

        when:
        def message = underTest.get()

        then:
        message == expected

        where:
        zoneName      | date         | time       || hours | minutes | seconds
        'Europe/Rome' | '2018-03-25' | '01:00:00' || 22    | 0       | 0
        'Europe/Rome' | '2018-03-25' | '03:00:00' || 21    | 0       | 0
        'Europe/Rome' | '2022-03-26' | '01:00:00' || 23    | 0       | 0
        'Europe/Rome' | '2022-03-26' | '03:00:00' || 21    | 0       | 0

        and:
        zone = ZoneId.of(zoneName)
        now = LocalDateTime.parse(date + 'T' + time).atZone(zone).toInstant()
        clock = Clock.fixed(now, zone)

        and:
        expected = "Hurry, sale ends at midnight, time left: $hours hours, $minutes minutes, $seconds seconds"
    }
}
