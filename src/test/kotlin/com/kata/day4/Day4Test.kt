package com.kata.day4

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Day4Test {

    @Test
    fun `convert a line to a pair of lists`() {

        val pairFromLine = Day4().convertLineToLists("Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53")

        assertThat(pairFromLine.first).isEqualTo(listOf(41, 48, 83, 86, 17))
        assertThat(pairFromLine.second).isEqualTo(listOf(83, 86,  6, 31, 17,  9, 48, 53))
    }
}