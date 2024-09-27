package com.kata.day5

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Day5Test {

    @Test
    fun readSeedsLine() {
        val seeds = Day5().readSeeds(listOf("seeds: 79 14 55 13", "", "seed-to-soil map:", "50 12 32"))
        assertThat(seeds).containsExactly(79, 14, 55, 13)
    }
}