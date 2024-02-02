package com.kata.day1

import kotlin.streams.toList

class Calibrator {

    fun calculateResult() = 0
    fun extractTwoDigits(line: String): Int {
        findDigits(line)
        return 0
    }

    fun findDigits(line: String): List<Int> {
        return line.toCharArray()
            .filter { it.isDigit() }
            .map { it.digitToInt() }
    }

}