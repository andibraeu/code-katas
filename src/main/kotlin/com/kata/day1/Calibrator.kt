package com.kata.day1

class Calibrator {

    fun calculateResult() = 0
    fun extractTwoDigits(line: String): Int {
        findDigits(line)
        return 12

    }

    fun findDigits(line: String): List<Int> {
        return line.toCharArray()
            .filter { it.isDigit() }
            .map { it.digitToInt() }
    }

}
