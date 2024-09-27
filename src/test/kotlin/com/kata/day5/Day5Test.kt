package com.kata.day5

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Day5Test {

    @Test
    fun readSeedsLine() {
        val seeds = Day5().readSeeds(listOf("seeds: 79 14 55 13", "", "seed-to-soil map:", "50 12 32"))
        assertThat(seeds).containsExactly(79, 14, 55, 13)
    }

    @Test
    fun readMaps() {
        val maps = Day5().readMaps(listOf("seeds: 79 14 55 13", "",
            "seed-to-soil map:",
            "50 98 2",
            "52 50 48",
            "",
            "soil-to-fertilizer map:",
            "0 15 37",
            "37 52 2",
            "39 0 15"
        ))
        val expected = mapOf(
            "seed-to-soil" to listOf("50 98 2", "52 50 48"),
            "soil-to-fertilizer" to listOf("0 15 37", "37 52 2", "39 0 15")
        )
        assertThat(maps).isEqualTo(expected)
    }

}