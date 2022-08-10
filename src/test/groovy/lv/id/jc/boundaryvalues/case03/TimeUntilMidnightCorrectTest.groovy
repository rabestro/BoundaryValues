package lv.id.jc.boundaryvalues.case03

import spock.lang.Specification

import java.time.Clock
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId

class TimeUntilMidnightCorrectTest extends Specification {
    final ZONE = ZoneId.of('Europe/Rome')

    def "Get"() {
        given:
        def underTest = new TimeUntilMidnightCorrect(clock)

        when:
        def message = underTest.get()

        then:
        message == expected

        where:
        now                         | hours | minutes | seconds
        '2018-03-25T01:00:00' | 23    | 0       | 0
        '2018-03-25T03:00:00' | 21    | 0       | 0
        '2022-03-26T01:00:00' | 23    | 0       | 0
        '2022-03-28T01:00:00' | 23    | 0       | 0

        and:
        clock = Clock.fixed(Instant.parse(now), ZoneId.of('Europe/Rome'))

        and:
        expected = "Hurry, sale ends at midnight, time left: $hours hours, $minutes minutes, $seconds seconds"
    }
}
