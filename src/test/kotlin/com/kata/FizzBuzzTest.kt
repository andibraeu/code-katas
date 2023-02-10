package com.kata

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class FizzBuzzTest {
    @Test
    fun `returns list of numbers`() {
        val fizzBuzz = FizzBuzz()

        val strings = fizzBuzz.printNumbers()
        assertThat(strings).hasSize(100)
        assertThat(strings.first()).isEqualTo("1")
        assertThat(strings.last()).isEqualTo("100")
    }


}