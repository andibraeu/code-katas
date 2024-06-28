package com.kata.day3

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class Day3Test {

    @ParameterizedTest
    @MethodSource("extractNumbersInput")
    fun `test line with two numbers`(input: String, expectedResult: List<NumberWithPosition>) {
        val result = Day3().extractNumbersWithPosition(input)

        assertThat(result).isEqualTo(expectedResult)
    }

    private fun extractNumbersInput(): Stream<Arguments> = Stream.of(
        Arguments.of("467..114..", listOf(NumberWithPosition(467, 0..2), NumberWithPosition(114, 5..7), )),
        Arguments.of("...*......", emptyList<NumberWithPosition>()),
        Arguments.of("...*...456", listOf(NumberWithPosition(456, 7..9))),
        Arguments.of("...*.....6", listOf(NumberWithPosition(6, 9..9))),
    )
}
