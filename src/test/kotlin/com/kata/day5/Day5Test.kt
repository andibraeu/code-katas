package com.kata.day5

import java.util.stream.Stream
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class Day5Test {

    @Test
    fun readSeedsLine() {
        val seeds = Day5().readSeeds(listOf("seeds: 79 14 55 13", "", "seed-to-soil map:", "50 12 32"))
        assertThat(seeds).containsExactly(79, 14, 55, 13)
    }

    @Test
    fun readSeedRanges() {
        val seeds = Day5().readSeedRanges(listOf("seeds: 79 14 55 13", "", "seed-to-soil map:", "50 12 32"))
        assertThat(seeds).containsExactly(79..92L, 55..67L)
    }

    @Test
    fun readMaps() {
        val maps = Day5().readMaps(
            listOf(
                "seeds: 79 14 55 13", "",
                "seed-to-soil map:",
                "50 98 2",
                "52 50 48",
                "",
                "soil-to-fertilizer map:",
                "0 15 37",
                "37 52 2",
                "39 0 15"
            )
        )
        val expected = listOf(
            listOf(MapEntry(98L..99, -48), MapEntry(50L..97, 2)),
            listOf(MapEntry(15L..51, -15), MapEntry(52L..53, -15), MapEntry(0L..14, 39))
        )
        assertThat(maps).isEqualTo(expected)
    }

    @ParameterizedTest
    @MethodSource("mapAssignments")
    fun getSoilType(input: Long, expected: Long) {
        val seedToSoilMap = listOf(MapEntry(98L..99, -48), MapEntry(50L..97, 2))
        val result = Day5().getSoilFromSeed(input, seedToSoilMap)
        assertThat(result).isEqualTo(expected)
    }

    private fun mapAssignments(): Stream<Arguments> = Stream.of(
        Arguments.of(79, 81),
        Arguments.of(98, 50),
        Arguments.of(15, 15),
        Arguments.of(100, 100),
    )

    @ParameterizedTest
    @MethodSource("seedToFertilizerAssignment")
    fun resolveFertilizer(seed: Long, expected: Long) {
        val input = listOf(
            listOf(MapEntry(98L..99, -48), MapEntry(50L..97, 2)),
            listOf(MapEntry(15L..51, -15), MapEntry(52L..53, -15), MapEntry(0L..14, 39))
        )
        val result = Day5().walkThroughMaps(seed, input)
        assertThat(result).isEqualTo(expected)
    }

    private fun seedToFertilizerAssignment(): Stream<Arguments> = Stream.of(
        Arguments.of(79, 81),
        Arguments.of(14, 53),
        Arguments.of(55, 57),
        Arguments.of(13, 52),
    )


    @Test
    fun convertToMapEntry() {
        val entry = "50 98 2"

        val result = Day5().convertToMapEntry(entry)
        assertThat(result).isEqualTo(MapEntry(98L..99, -48))
    }

}
