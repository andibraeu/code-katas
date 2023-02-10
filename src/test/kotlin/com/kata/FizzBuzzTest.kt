package com.kata

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class FizzBuzzTest {
    @Test
    fun `returns list of numbers`() {
        val fizzBuzz = FizzBuzz()

        val strings = fizzBuzz.printNumbers()
        assertThat(strings).hasSize(100)
        assertThat(strings.first()).isEqualTo("1")
        assertThat(strings.last()).isEqualTo("sauna")
    }

    @Test
    fun `replace multiples of 3 with kuksa`() {
        val fizzBuzz = FizzBuzz()

        val strings = fizzBuzz.printNumbers()
        assertThat(strings[2]).isEqualTo("kuksa")
        assertThat(strings[5]).isEqualTo("kuksa")
        assertThat(strings[8]).isEqualTo("kuksa")
        assertThat(strings[11]).isEqualTo("kuksa")
        assertThat(strings[98]).isEqualTo("kuksa")
    }

    @Test
    fun `replace multiples of 5 with sauna`() {
        val fizzBuzz = FizzBuzz()

        val strings = fizzBuzz.printNumbers()
        assertThat(strings[4]).isEqualTo("sauna")
        assertThat(strings[9]).isEqualTo("sauna")
        assertThat(strings[19]).isEqualTo("sauna")
        assertThat(strings[99]).isEqualTo("sauna")
    }

    @Test
    fun `replace multiples of 15 with dip`() {
        val fizzBuzz = FizzBuzz()

        val strings = fizzBuzz.printNumbers()
        assertThat(strings[14]).isEqualTo("dip")
    }
}