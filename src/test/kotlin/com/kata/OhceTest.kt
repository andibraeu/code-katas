package com.kata

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.*
import java.time.Instant

internal class OhceTest {

    private val morning = Instant.parse("2018-11-30T10:35:24.00Z")
    private val afternoon = Instant.parse("2018-11-30T18:35:24.00Z")
    private val nightBeforeMidnight = Instant.parse("2018-11-30T22:35:24.00Z")
    private val nightAfterMidnight = Instant.parse("2018-11-30T03:35:24.00Z")

    @Test
    fun `return single character`() {
        val reverseWord = Ohce().generateOutput("a", afternoon)
        assertThat(reverseWord.first).isEqualTo("a\n¡Bonita palabra!")
        assertThat(reverseWord.second).isTrue
    }

    @Test
    fun `reverse multiple character`() {
        val reverseWord = Ohce().generateOutput("hello", afternoon)
        assertThat(reverseWord.first).isEqualTo("olleh")
        assertThat(reverseWord.second).isTrue
    }

    @Test
    fun `reverse palindrome`() {
        val ohce = Ohce()
        val word = "anna"
        val reverseWord = ohce.generateOutput(word, afternoon)

        assertThat(reverseWord.first).isEqualTo("anna\n¡Bonita palabra!")
        assertThat(reverseWord.second).isTrue
    }

    @Test
    fun `reverse non-palindrome`() {
        val ohce = Ohce()
        val word = "andreas"
        val reverseWord = ohce.generateOutput(word, afternoon)

        assertThat(reverseWord.first).isNotEqualTo(word)
        assertThat(reverseWord.second).isTrue
    }

    @Test
    fun `greet user in the afternoon`() {
        val ohce = Ohce()
        val result = ohce.generateOutput("ohce Moni", afternoon)

        assertThat(result.first).isEqualTo("¡Buenas tardes Moni!")
        assertThat(ohce.name).isEqualTo("Moni")
        assertThat(result.second).isTrue
    }

    @Test
    fun `greet user before midnight`() {
        val ohce = Ohce()
        val result = ohce.generateOutput("ohce Moni", nightBeforeMidnight)

        assertThat(result.first).isEqualTo("¡Buenas noches Moni!")
        assertThat(ohce.name).isEqualTo("Moni")
        assertThat(result.second).isTrue

    }

    @Test
    fun `greet user after midnight`() {
        val ohce = Ohce()
        val result = ohce.generateOutput("ohce Moni", nightAfterMidnight)

        assertThat(result.first).isEqualTo("¡Buenas noches Moni!")
        assertThat(ohce.name).isEqualTo("Moni")
        assertThat(result.second).isTrue

    }

    @Test
    fun `greet user in the morning`() {
        val ohce = Ohce()
        val result = ohce.generateOutput("ohce Moni", morning)

        assertThat(result.first).isEqualTo("¡Buenos días Moni!")
        assertThat(ohce.name).isEqualTo("Moni")
        assertThat(result.second).isTrue

    }

    @Test
    fun `say adios`() {
        val ohce = Ohce()
        ohce.generateOutput("ohce Eva", afternoon)
        val result = ohce.generateOutput("Stop!", afternoon)

        assertThat(result.first).isEqualTo("Adios Eva")
        assertThat(result.second).isFalse
    }
}
