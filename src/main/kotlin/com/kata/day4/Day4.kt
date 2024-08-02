package com.kata.day4

import java.io.File
import kotlin.math.pow

class Day4 {

    fun processInput(inputLines: List<String>, part2: Boolean = false): Int {
        val winningNumbers = inputLines.map { convertLineToLists(it) }
            .map { countWinningNumbers(it) }

        return if (part2) {
            0
        } else
            winningNumbers
                .filter { it > 0 }.sumOf { 2.toDouble().pow(it - 1).toInt() }

    }

    fun countWinningNumbers(pair: Pair<List<Int>, List<Int>>): Int =
        pair.second
            .filter { pair.first.contains(it) }
            .size

    fun convertLineToLists(line: String): Pair<List<Int>, List<Int>> {
        val splittedString = line.split(":").last()
            .split("|")
        val winningNumbers = splittedString[0].toIntList()
        val numbersPool = splittedString[1].toIntList()

        return Pair(winningNumbers, numbersPool)
    }

    private fun String.toIntList() = trim()
        .split(" ")
        .filter { it.isNotBlank() }
        .map { it.toInt() }
}

fun main() {
    val list = File("src/main/resources/day4/test_input.txt").bufferedReader().readLines()

    println(Day4().processInput(list, false))
}

