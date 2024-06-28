package com.kata.day3

import java.io.File

class Day3 {

    fun processInput(inputLines: List<String>, part2: Boolean = false): Int {
        return 5
    }

    fun extractNumbersWithPosition(line: String): List<NumberWithPosition> {
        val regex = Regex("\\d+")
        val findAll = regex.findAll(line, 0)
        return findAll.map { NumberWithPosition(it.value.toInt(), it.groups[0]?.range) }.toList()
    }

}

data class NumberWithPosition(
    val value: Int,
    val position: IntRange?
)

fun main() {
    val list = File("src/main/resources/day3/test_input.txt").bufferedReader().readLines()

    println(Day3().processInput(list, false))
}

