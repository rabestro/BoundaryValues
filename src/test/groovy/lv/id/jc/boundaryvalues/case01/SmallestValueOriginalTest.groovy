package lv.id.jc.boundaryvalues.case01


import spock.lang.Specification
import spock.lang.Timeout

class SmallestValueOriginalTest extends Specification {
    static def F19 = 121_645_100_408_832_000
    static def F20 = 2_432_902_008_176_640_000

    @Timeout(2)
    def 'should calculate the smallest value'() {
        given:
        def underTest = new SmallestValueOriginal()

        expect:
        underTest.applyAsInt(number) == expected

        where:
        number                 | expected
        1                      | 2
        2                      | 3
        100                    | 5
        Integer.MAX_VALUE      | 13
        Integer.MAX_VALUE + 1L | 13
        6_227_020_800          | 14
        87_178_291_200         | 15
        1_307_674_368_000      | 16
        20_922_789_888_000     | 17
        F19 - 1                | 19
        F19                    | 20
        F19 + 1                | 20
        F20 - 1                | 20
        F20                    | 21
        F20 + 1                | 21
        F20 + 2                | 21
        F20 + 3                | 21
        Long.MAX_VALUE         | 21
    }
}
