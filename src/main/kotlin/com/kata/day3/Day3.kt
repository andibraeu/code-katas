package com.kata.day3

import java.io.File

class Day3 {

    fun processInput(inputLines: List<String>, part2: Boolean = false): Int {
        val numbersList = inputLines.map {
            extractNumbersWithPosition(it)
        }
        val symbolsList = inputLines.map {
            extractSymbolsWithPosition(it)
        }
        val result = findNumbersNextToSymbols(numbersList, symbolsList)
        return 5
    }

    internal fun findNumbersNextToSymbols(
        numbersList: List<List<NumberWithPosition>>,
        symbolsList: List<List<SymbolWithPosition>>
    ): List<Int> {
        numbersList.forEachIndexed { lineNumber, numberWithPositions ->
            numberWithPositions
                .filter {
                    val symbolsInCurrentLine = symbolsList[lineNumber]
                    val realPosition = it.position.first - 1 .. it.position.last + 1
                    symbolsInCurrentLine[0].position in it.position
                }
            // TODO: Zahlen merken und benachbarte Zeilen berücksichtigen
        }
        return emptyList()
    }

    fun extractNumbersWithPosition(line: String): List<NumberWithPosition> {
        val regex = Regex("\\d+")
        val findAll = regex.findAll(line, 0)
        return findAll.map { NumberWithPosition(it.value.toInt(), it.groups[0]?.range!!) }.toList()
    }

    fun extractSymbolsWithPosition(line: String): List<SymbolWithPosition> {
        val regex = Regex("[^.0-9]")
        val findAll = regex.findAll(line, 0)
        return findAll.map { SymbolWithPosition(it.value, it.groups[0]?.range!!.first) }.toList()
    }

}

data class SymbolWithPosition(
    val value: String,
    val position: Int
)

data class NumberWithPosition(
    val value: Int,
    val position: IntRange
)

fun main() {
    val list = File("src/main/resources/day3/test_input.txt").bufferedReader().readLines()

    println(Day3().processInput(list, false))
}

