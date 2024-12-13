package com.kata.day6

import com.kata.day5.Day5
import java.util.stream.Stream
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class Day6Test {

    @ParameterizedTest
    @MethodSource("testData")
    fun calculateZeroPoints(time: Int, distance: Int, expectedResult: IntRange) {

        val result: IntRange = Day6().calculateZeroPoints(time, distance)

        println(result.toList())
        assertThat(result).isEqualTo(expectedResult)

    }

    @Test
    fun readInputsLine() {
        val timeList = Day6().readInput(listOf("Time:      7  15   30", "Distance:  9  40  200"), "Time")
        val distanceList = Day6().readInput(listOf("Time:      7  15   30", "Distance:  9  40  200"), "Distance")
        assertThat(timeList).containsExactly(7, 15, 30)
        assertThat(distanceList).containsExactly(9, 40, 200)
    }

    @Test
    fun readInputsLinePart2() {
        val timeList = Day6().readInputPart2(listOf("Time:      7  15   30", "Distance:  9  40  200"), "Time")
        val distanceList = Day6().readInputPart2(listOf("Time:      7  15   30", "Distance:  9  40  200"), "Distance")
        assertThat(timeList).containsExactly(71530)
        assertThat(distanceList).containsExactly(940200)
    }

    private fun testData(): Stream<Arguments> =
        Stream.of(
            Arguments.of(7, 9, 2..<6),
            Arguments.of(15, 40, 4..<12),
            Arguments.of(30, 200, 11..<20),
        )

}
