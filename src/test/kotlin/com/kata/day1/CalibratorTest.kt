package com.kata.day1

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

class CalibratorTest {

    private val calibrator = Calibrator()
    @Test
    @Disabled
    fun test() {
        val result = calibrator.extractTwoDigits("1abc2")
        assertThat(result).isEqualTo(12)
    }

    @Test
    fun getDigitListFor2Digits() {
        val result = calibrator.findDigits("1abc2")
        assertThat(result).containsExactly(1,2)
    }

    @Test
    fun getDigitListFor1Digit() {
        val result = calibrator.findDigits("treb7uchet")
        assertThat(result).containsExactly(7)
    }

    @Test
    fun getDigitListFor4Digits() {
        val result = calibrator.findDigits("a1b2c3d4e5f")
        assertThat(result).containsExactly(1,2,3,4,5)
    }


}