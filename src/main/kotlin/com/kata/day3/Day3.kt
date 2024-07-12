package com.kata.day3

import java.io.File

class Day3 {

    fun processInput(inputLines: List<String>, part2: Boolean = false): Int {
        return calculatePart1(inputLines)
    }

    private fun calculatePart1(inputLines: List<String>): Int {
        val numbersList = inputLines.map {
            extractNumbersWithPosition(it)
        }
        val symbolsList = inputLines.map {
            extractSymbolsWithPosition(it)
        }
        return findNumbersNextToSymbols(numbersList, symbolsList).sum()
    }

    internal fun findNumbersNextToSymbols(
        numbersList: List<List<NumberWithPosition>>,
        symbolsList: List<List<SymbolWithPosition>>
    ): List<Int> {

        val sameLine = calculateLine(numbersList, symbolsList, 0)
        val upperLine = calculateLine(numbersList, symbolsList, -1)
        val lowerLine = calculateLine(numbersList, symbolsList, 1)

        return sameLine + upperLine + lowerLine
    }

    private fun calculateLine(
        numbersList: List<List<NumberWithPosition>>,
        symbolsList: List<List<SymbolWithPosition>>,
        lineShift: Int
    ) = numbersList.mapIndexed { lineNumber, numberWithPositions ->
        numberWithPositions
            .filter { filterLine(symbolsList, lineNumber + lineShift, it) }
            .map { it.value }
    }.flatten()

    private fun filterLine(
        symbolsList: List<List<SymbolWithPosition>>,
        lineNumber: Int,
        numberWithPosition: NumberWithPosition
    ): Boolean {
        try {
            val symbolsInCurrentLine = symbolsList[lineNumber]
            return if (symbolsInCurrentLine.isEmpty())
                false
            else {
                symbolsInCurrentLine.any { symbolInCurrentLine ->
                    val realPosition = numberWithPosition.position.first - 1..numberWithPosition.position.last + 1
                    symbolInCurrentLine.position in realPosition
                }
            }
        } catch (e: Exception) {
            return false
        }
    }

    fun extractNumbersWithPosition(line: String): List<NumberWithPosition> {
        val regex = Regex("\\d+")
        val findAll = regex.findAll(line, 0)
        return findAll.map { NumberWithPosition(it.value.toInt(), it.groups[0]?.range!!) }.toList()
    }

    fun extractSymbolsWithPosition(line: String): List<SymbolWithPosition> {
        return symbolWithPositions(line, "[^.0-9]")
    }

    fun extractStar(line: String): List<SymbolWithPosition> {
        return symbolWithPositions(line, "\\*")
    }

    private fun symbolWithPositions(line: String, pattern: String): List<SymbolWithPosition> {
        val regex = Regex(pattern)
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

