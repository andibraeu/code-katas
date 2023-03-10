package com.kata

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.*

internal class OhceTest {

    @Test
    fun `return single character`() {
        val reverseWord = Ohce().generateOutput("a")
        assertThat(reverseWord.first).isEqualTo("a\n¡Bonita palabra!")
        assertThat(reverseWord.second).isTrue
    }

    @Test
    fun `reverse multiple character`() {
        val reverseWord = Ohce().generateOutput("hello")
        assertThat(reverseWord.first).isEqualTo("olleh")
        assertThat(reverseWord.second).isTrue
    }

    @Test
    fun `reverse palindrome`() {
        val ohce = Ohce()
        val word = "anna"
        val reverseWord = ohce.generateOutput(word)

        assertThat(reverseWord.first).isEqualTo("anna\n¡Bonita palabra!")
        assertThat(reverseWord.second).isTrue
    }

    @Test
    fun `reverse non-palindrome`() {
        val ohce = Ohce()
        val word = "andreas"
        val reverseWord = ohce.generateOutput(word)

        assertThat(reverseWord.first).isNotEqualTo(word)
        assertThat(reverseWord.second).isTrue
    }

    @Test
    fun `greet user`() {
        val ohce = Ohce()
        val result = ohce.generateOutput("ohce Moni")

        assertThat(result.first).isEqualTo("¡Buenos días Moni!")
        assertThat(ohce.name).isEqualTo("Moni")
        assertThat(result.second).isTrue

    }

    @Test
    fun `say adios`() {
        val ohce = Ohce()
        ohce.generateOutput("ohce Eva")
        val result = ohce.generateOutput("Stop!")

        assertThat(result.first).isEqualTo("Adios Eva")
        assertThat(result.second).isFalse

    }
}
