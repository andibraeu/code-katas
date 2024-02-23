package com.kata.day1

import java.io.File

class Calibrator {
    fun processList(lines: List<String>, part2: Boolean) =
        if (part2) lines.sumOf { extractTwoDigitsFromStringsAndDigits(it) }
            else  lines.sumOf { extractTwoDigits(it) }

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
        val replaceWordByDigit = line.replaceWordByDigit(firstDigitWord, wordToDigitMap)

        val first = findDigits(replaceWordByDigit).first()

        val finalLine = line.replaceWordByDigit(lastDigitWord, wordToDigitMap)
        val last = findDigits(finalLine).last()

        val result = first * 10 + last
        println("$line : $result")
        return result
    }

    private fun String.replaceWordByDigit(
        digitWord: String?,
        wordToDigitMap: Map<String, String>
    ) = digitWord?.let { replace(it, wordToDigitMap[digitWord]!!) } ?: this
}

fun main() {
    val list = File("src/main/resources/initial_input.txt").bufferedReader().readLines()

    println(Calibrator().processList(list, true))
}
