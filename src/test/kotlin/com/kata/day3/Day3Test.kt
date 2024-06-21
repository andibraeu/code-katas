package com.kata.day3

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Day3Test {

    @Test
    fun `test line with two numbers`() {
        val result = Day3().extractNumbersWithPosition("467..114..")

        assertThat(result)
            .containsExactly(
                NumberWithPosition(467, 0..2),
                NumberWithPosition(114, 5..7),
            )
    }

    @Test
    fun `test line with no numbers`() {
        val result = Day3().extractNumbersWithPosition("...*......")

        assertThat(result).isEmpty()
    }
}
