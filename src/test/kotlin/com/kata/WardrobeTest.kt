package com.kata

import com.kata.Size.TINY
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class WardrobeTest {

    @Test
    fun `find 250 sized combinations`() {
        val greeting = Wardrobe().getAll250CmCombinations()
        assertThat(greeting).contains(listOf(TINY, TINY, TINY, TINY, TINY))
    }

    // TODO find all candidates

    // TODO refactor to usage of recursion

    //TODO prices
}
