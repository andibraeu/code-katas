package com.kata.day2

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource
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
    fun splitGameAndGrabs(line: String, result: Int) {
        val game = Day2().splitGameIdAndGrabs(line)
        assertThat(game.id).isEqualTo(result)
    }

    private fun gameIdToExtract() = Stream.of(
        Arguments.of("Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green", 1),
        Arguments.of("Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue", 2),
        Arguments.of("Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red", 3),
        Arguments.of("Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red", 4),
        Arguments.of("Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green", 5),
    )

}