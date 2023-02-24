package com.kata

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.*

internal class OhceTest {

    @Test fun `return single character`() {
        val reverseWord = Ohce().generateOutput("a")
       assertThat(reverseWord).isEqualTo("a")
    }

    @Test fun `reverse multiple character`() {
        val reverseWord = Ohce().generateOutput("hello")
        assertThat(reverseWord).isEqualTo("olleh")
    }

    @Test fun `reverse palindrome`() {
        val ohce = Ohce()
        val word = "anna"
        val reverseWord = ohce.generateOutput(word)
        val isPalindrome = ohce.isPalindrome(word)

        assertThat(reverseWord).isEqualTo(word)
        assertThat(isPalindrome).isTrue
    }

    @Test fun `reverse non-palindrome`() {
        val ohce = Ohce()
        val word = "andreas"
        val reverseWord = ohce.generateOutput(word)
        val isPalindrome = ohce.isPalindrome(word)

        assertThat(reverseWord).isNotEqualTo(word)
        assertThat(isPalindrome).isFalse
    }

    @Test fun `greet user`() {
        val result = Ohce().generateOutput("ohce Moni")

        assertThat(result).isEqualTo("¡Buenos días Moni!")
    }
}
