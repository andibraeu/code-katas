package com.kata.day1

class Calibrator {

    fun extractTwoDigits(line: String) =
        findDigits(line).first() * 10 + findDigits(line).last()

    fun findDigits(line: String): List<Int> {
        return line.toCharArray()
            .filter { it.isDigit() }
            .map { it.digitToInt() }
    }

    fun processList(lines: List<String>) =
        lines.map { extractTwoDigits(it) }.sum()

}
