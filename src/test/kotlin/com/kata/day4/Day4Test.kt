package com.kata.day4

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import kotlin.math.pow

class Day4Test {

    @Test
    fun `convert a line to a pair of lists`() {

        val pairFromLine = Day4().convertLineToLists("Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53")

        assertThat(pairFromLine.first).isEqualTo(listOf(41, 48, 83, 86, 17))
        assertThat(pairFromLine.second).isEqualTo(listOf(83, 86,  6, 31, 17,  9, 48, 53))
    }

    @Test
    fun `count winning numbers in a line`() {

        val result = Day4().countWinningNumbers(Pair(listOf(41, 48, 83, 86, 17), listOf(83, 86,  6, 31, 17,  9, 48, 53)))

        assertThat(2.toDouble().pow(3)).isEqualTo(4.0)
        assertThat(result).isEqualTo(4)
    }
}