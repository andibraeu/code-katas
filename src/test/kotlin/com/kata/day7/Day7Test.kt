package com.kata.day7

import java.util.stream.Stream
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class Day7Test {


    @ParameterizedTest
    @MethodSource("testData")
    fun evaluateHand(hand: List<Cards>, expectedResult: Types) {
        val evaluateHand = Day7().evaluateHand(hand)

        assertThat(evaluateHand).isEqualTo(expectedResult)
    }

    private fun testData() =
        Stream.of(
            Arguments.of(listOf(Cards.SEVEN, Cards.SEVEN, Cards.SIX, Cards.SIX, Cards.FIVE), Types.TWO_PAIR)
        )

}
