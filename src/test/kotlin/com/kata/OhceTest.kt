package com.kata

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.*

internal class OhceTest {

    @Test fun `return single character`() {
        val reverseWord = Ohce().reverseWord("a")
       assertThat(reverseWord).isEqualTo("a")
    }

    @Test fun `reverse multiple character`() {
        val reverseWord = Ohce().reverseWord("hello")
        assertThat(reverseWord).isEqualTo("olleh")
    }
}
