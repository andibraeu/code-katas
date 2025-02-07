package com.kata.day7

import com.kata.day7.Cards.FIVE
import com.kata.day7.Cards.FOUR
import com.kata.day7.Cards.K
import com.kata.day7.Cards.SEVEN
import com.kata.day7.Cards.SIX
import com.kata.day7.Cards.TWO
import com.kata.day7.Types.FIVE_OF_A_KIND
import com.kata.day7.Types.FOUR_OF_A_KIND
import com.kata.day7.Types.FULL_HOUSE
import com.kata.day7.Types.HIGH_CARD
import com.kata.day7.Types.ONE_PAIR
import com.kata.day7.Types.THREE_OF_A_KIND
import com.kata.day7.Types.TWO_PAIR
import java.util.stream.Stream
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.of
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
            of(listOf(SEVEN, SEVEN, SEVEN, SEVEN, SEVEN), FIVE_OF_A_KIND),
            of(listOf(SEVEN, SEVEN, SEVEN, SEVEN, SIX), FOUR_OF_A_KIND),
            of(listOf(SEVEN, SEVEN, SEVEN, SIX, SIX), FULL_HOUSE),
            of(listOf(SEVEN, SEVEN, SEVEN, FOUR, SIX), THREE_OF_A_KIND),
            of(listOf(SEVEN, SEVEN, SIX, SIX, FIVE), TWO_PAIR),
            of(listOf(SEVEN, TWO, SIX, SIX, FIVE), ONE_PAIR),
            of(listOf(SEVEN, TWO, K, SIX, FIVE), HIGH_CARD),
        )

}
