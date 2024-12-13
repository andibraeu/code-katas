package com.kata.day6

import java.util.stream.Stream
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class Day6Test {

    @ParameterizedTest
    @MethodSource("testData")
    fun calculateZeroPoints(time: Int, distance: Int, expectedResult: IntRange) {

        val result: IntRange = Day6().calculateZeroPoints(time, distance)

        assertThat(result).isEqualTo(expectedResult)

    }

    private fun testData(): Stream<Arguments> =
        Stream.of(
            Arguments.of(7, 9, 2..<6),
            Arguments.of(15, 40, 4..<12),
            Arguments.of(30, 200, 11..<20),
        )

}
