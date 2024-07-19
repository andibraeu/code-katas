package com.kata.day4

import java.io.File

class Day4 {

    fun processInput(inputLines: List<String>, part2: Boolean = false): Int {
        return 0
    }

    fun convertLineToLists(line: String): Pair<List<Int>, List<Int>> {
        val splittedString = line.split(":").last()
            .split("|")
        val winningNumbers = splittedString[0].toIntList()
        val numbersPool = splittedString[1].toIntList()

        return Pair(winningNumbers, numbersPool)
    }
c
    private fun String.toIntList() =  trim()
        .split(" ")
        .filter { it.isNotBlank() }
        .map { it.toInt() }
}

fun main() {
    val list = File("src/main/resources/day4/test_input.txt").bufferedReader().readLines()

    println(Day4().processInput(list, false))
}

