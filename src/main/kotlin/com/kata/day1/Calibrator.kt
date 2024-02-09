package com.kata.day1

import java.io.File

class Calibrator {
    fun processList(lines: List<String>) =
        lines.sumOf { extractTwoDigits(it, false) }

    internal fun extractTwoDigits(line: String, withStringNumbers: Boolean) =
        findDigits(line).first() * 10 + findDigits(line).last()

    internal fun findDigits(line: String) =
        line.toCharArray()
            .filter { it.isDigit() }
            .map { it.digitToInt() }

    fun extractTwoDigitsFromStringsAndDigits(line: String) =
        extractTwoDigits(line, true)
}

fun main() {
    val list = File("src/main/resources/input.txt").bufferedReader().readLines()

    println(Calibrator().processList(list))
}
