package com.kata.day1

import java.io.File

class Calibrator {
    fun processList(lines: List<String>) =
        lines.sumOf { extractTwoDigits(it) }

    internal fun extractTwoDigits(line: String) =
        findDigits(line).first() * 10 + findDigits(line).last()

    internal fun findDigits(line: String) =
        line.toCharArray()
            .filter { it.isDigit() }
            .map { it.digitToInt() }

    internal fun extractTwoDigitsFromStringsAndDigits(line: String): Int {
        val wordToDigitMap = mapOf(
            "one" to  "1",
            "two" to  "2",
            "three" to  "3",
            "four" to  "4",
            "five" to  "5",
            "six" to  "6",
            "seven" to  "7",
            "eight" to  "8",
            "nine" to  "9",
        )
        val firstDigitWord = line.findAnyOf(wordToDigitMap.keys)?.second
        val lastDigitWord = line.findLastAnyOf(wordToDigitMap.keys)?.second
        val convertedLine = firstDigitWord?.let { line.replace(it, wordToDigitMap[firstDigitWord]!!) } ?: line
        val finalLine = lastDigitWord?.let { convertedLine.replace(it, wordToDigitMap[lastDigitWord]!!) } ?: convertedLine
        return extractTwoDigits(finalLine)
    }
}

fun main() {
    val list = File("src/main/resources/input.txt").bufferedReader().readLines()

    println(Calibrator().processList(list))
}
