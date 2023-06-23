package com.kata

import com.kata.Size.LARGE
import com.kata.Size.MEDIUM
import com.kata.Size.TINY
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class WardrobeTest {

    @Test
    fun `find 250 sized combinations`() {
        val greeting = Wardrobe().getAll250CmCombinations()
        assertThat(greeting).contains(listOf(TINY, TINY, TINY, TINY, TINY))
        assertThat(greeting).contains(listOf(MEDIUM, TINY, TINY, TINY))
        assertThat(greeting).contains(listOf(MEDIUM, MEDIUM, TINY))
    }

    @Test
    fun `120 length is never used`() {
        val greeting = Wardrobe().getAll250CmCombinations()
        greeting.forEach { assertThat(it).doesNotContain(LARGE) }
    }

    @Test
    fun `create wardrobe tree`() {
        val tree = Wardrobe().createTree()

        assertThat(tree.value).isNull()
        assertThat(tree.children).hasSize(4)
        val sizes = tree.children.map { it.value }
        assertThat(sizes).containsExactlyElementsOf(Size.values().toMutableList())
    }

    // TODO find all candidates

    // TODO refactor to usage of recursion

    // TODO prices
}
