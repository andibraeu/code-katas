package com.kata.day3

import java.util.stream.Stream
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class Day3Test {

    @ParameterizedTest
    @MethodSource("extractNumbersInput")
    fun `test line with numbers`(input: String, expectedResult: List<NumberWithPosition>) {
        val result = Day3().extractNumbersWithPosition(input)

        assertThat(result).isEqualTo(expectedResult)
    }

    private fun extractNumbersInput(): Stream<Arguments> = Stream.of(
        Arguments.of("467..114..", listOf(NumberWithPosition(467, 0..2), NumberWithPosition(114, 5..7))),
        Arguments.of("...*......", emptyList<NumberWithPosition>()),
        Arguments.of("...*...456", listOf(NumberWithPosition(456, 7..9))),
        Arguments.of("...*.....6", listOf(NumberWithPosition(6, 9..9))),
    )

    @ParameterizedTest
    @MethodSource("extractSymbolsInput")
    fun `test line with symbols`(input: String, expectedResult: List<SymbolWithPosition>) {
        val result = Day3().extractSymbolsWithPosition(input)

        assertThat(result).isEqualTo(expectedResult)
    }

    @ParameterizedTest
    @MethodSource("extractStar")
    fun `test line with star`(input: String, expectedResult: List<SymbolWithPosition>) {
        val result = Day3().extractStar(input)

        assertThat(result).isEqualTo(expectedResult)
    }


    private fun extractSymbolsInput(): Stream<Arguments> = Stream.of(
        Arguments.of("467..114..", emptyList<SymbolWithPosition>()),
        Arguments.of("...*....+.", listOf(SymbolWithPosition("*", 3), SymbolWithPosition("+", 8))),
        Arguments.of(
            "...*...#@/",
            listOf(
                SymbolWithPosition("*", 3),
                SymbolWithPosition("#", 7),
                SymbolWithPosition("@", 8),
                SymbolWithPosition("/", 9)
            )
        ),
        Arguments.of(
            ".(.*..?..$",
            listOf(
                SymbolWithPosition("(", 1),
                SymbolWithPosition("*", 3),
                SymbolWithPosition("?", 6),
                SymbolWithPosition("$", 9)
            )
        ),
    )

    private fun extractStar(): Stream<Arguments> = Stream.of(
        Arguments.of("467..114..", emptyList<SymbolWithPosition>()),
        Arguments.of("..*.....+.", listOf(SymbolWithPosition("*", 2))),
        Arguments.of("...*...#@/", listOf(SymbolWithPosition("*", 3))),
        Arguments.of(".(.*..?..$", listOf(SymbolWithPosition("*", 3))),
    )

    @Test
    fun `find numbers next to symbols`() {

        val symbolsList = listOf(
            emptyList(),
            listOf(SymbolWithPosition("*", 3)),
            emptyList(),
            listOf(SymbolWithPosition("#", 6)),
            listOf(SymbolWithPosition("*", 3)),
            listOf(SymbolWithPosition("+", 5)),
            emptyList(),
            emptyList(),
            listOf(SymbolWithPosition("$", 3), SymbolWithPosition("*", 5)),
            emptyList()
        )
        val result = Day3().findNumbersNextToSymbols(NUMBERS_LIST, symbolsList)

        assertThat(result).containsExactlyInAnyOrder(467, 35, 633, 617, 592, 755, 664, 598)
    }

    @Test
    fun `find pairs next to stars`() {

        val symbolsList = listOf(
            emptyList(),
            listOf(SymbolWithPosition("*", 3)),
            emptyList(),
            emptyList(),
            listOf(SymbolWithPosition("*", 3)),
            emptyList(),
            emptyList(),
            emptyList(),
            listOf(SymbolWithPosition("*", 5)),
            emptyList()
        )
        val result = Day3().findPairsNextToStars(symbolsList, NUMBERS_LIST)

        assertThat(result).containsExactlyInAnyOrder(467 to 35, 755 to 598)
    }

    companion object {
        val NUMBERS_LIST = listOf(
            listOf(NumberWithPosition(467, 0..2), NumberWithPosition(114, 5..7)),
            emptyList(),
            listOf(NumberWithPosition(35, 2..3), NumberWithPosition(633, 6..8)),
            emptyList(),
            listOf(NumberWithPosition(617, 0..2)),
            listOf(NumberWithPosition(58, 7..8)),
            listOf(NumberWithPosition(592, 2..4)),
            listOf(NumberWithPosition(755, 6..8)),
            emptyList(),
            listOf(NumberWithPosition(664, 1..3), NumberWithPosition(598, 5..7))
        )
    }
}
