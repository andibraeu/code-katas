package com.kata.day2

import com.kata.day2.Day2.Colors
import com.kata.day2.Day2.Colors.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class Day2Test {

    @Test
    fun testExampleInput() {
        val games = listOf(
            "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green",
            "Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue",
            "Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red",
            "Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red",
            "Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green"
        )
        assertThat(Day2().processInput(games, false)).isEqualTo(8)
    }

    @ParameterizedTest
    @MethodSource("gameIdToExtract")
    fun splitGameAndGrabs(line: String, grabs: List<String>, result: Int) {
        val game = Day2().splitGameIdAndGrabs(line)
        assertThat(game.id).isEqualTo(result)
        assertThat(game.grabs).isEqualTo(grabs)
    }

    private fun gameIdToExtract() = Stream.of(
        Arguments.of("Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green", listOf(mapOf(RED to 4, BLUE to 3), mapOf(RED to 1, GREEN to 2, BLUE to 6), mapOf(GREEN to 2)), 1),
        Arguments.of("Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue", listOf(mapOf(BLUE to 1 , GREEN to 2), mapOf(RED to 1, GREEN to 3, BLUE to 4), mapOf(GREEN to 1, BLUE to 1)), 2),
        Arguments.of("Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red", listOf(mapOf(GREEN to 8, BLUE to 6, RED to 20 ), mapOf(BLUE to 5 , RED to 4, GREEN to 13), mapOf(GREEN to 5, RED to 1)), 3),
        Arguments.of("Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red", listOf(mapOf(GREEN to 1 ,RED to 3, BLUE to 6 ), mapOf(GREEN to 3, RED to 6), mapOf(GREEN to 3, BLUE to 15, RED to 14)), 4),
        Arguments.of("Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green", listOf(mapOf(RED to 6, BLUE to 1, GREEN to 3), mapOf(BLUE to 2, RED to 1, GREEN to 2)), 5),
    )

    @Test
    fun getColorsAndNumbersTest() {
        val result = Day2().getColorsAndNumbers(listOf(" 3 blue, 4 red", " 1 red, 2 green, 6 blue", " 2 green"))
        assertThat(result).hasSize(3)
        assertThat(result).containsExactly(
            mapOf(BLUE to 3, RED to 4),
            mapOf(BLUE to 6, RED to 1, GREEN to 2),
            mapOf(GREEN to 2)
        )
    }
}
