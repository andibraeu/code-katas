package com.kata.day1

import java.util.stream.Stream
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class CalibratorTest {

    private val calibrator = Calibrator()

    @ParameterizedTest
    @MethodSource("testData")
    fun test(line: String, number: Int) {
        val result = calibrator.extractTwoDigits(line)
        assertThat(result).isEqualTo(number)
    }

    @Test
    fun getDigitListFor2Digits() {
        val result = calibrator.findDigits("1abc2")
        assertThat(result).containsExactly(1, 2)
    }

    @Test
    fun getDigitListFor1Digit() {
        val result = calibrator.findDigits("treb7uchet")
        assertThat(result).containsExactly(7)
    }

    @Test
    fun getDigitListFor4Digits() {
        val result = calibrator.findDigits("a1b2c3d4e5f")
        assertThat(result).containsExactly(1, 2, 3, 4, 5)
    }


    private fun testData() = Stream.of(
        Arguments.of("1abc2", 12),
        Arguments.of("treb7uchet", 77),
        Arguments.of("a1b2c3d4e5f", 15),
    )
}

