package com.kata

import com.kata.Size.LARGE
import com.kata.Size.MEDIUM
import com.kata.Size.SMALL
import com.kata.Size.TINY
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class WardrobeTest {

    @Test
    fun `find 250 sized combinations`() {
        val result = Wardrobe().getAll250CmCombinations()

        result.forEach {
            val size = it.sumBy { it.size }
            println("$it $size")
        }

        assertThat(result).contains(listOf(TINY, TINY, TINY, TINY, TINY))
        assertThat(result).contains(listOf(TINY, TINY, TINY, MEDIUM))
        assertThat(result).contains(listOf(TINY, MEDIUM, MEDIUM))
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

    @Test
    fun `check all paths without duplicates`() {
        val wardrobe = Wardrobe()
        val tree = wardrobe.createTree()

        val paths = wardrobe.findAllCandidates(tree, mutableListOf())

        assertThat(paths.size).isEqualTo(56)

    }

    @Test
    fun `has node children`() {
        val tree = WardrobeNode(null, listOf(
                WardrobeNode(SMALL, listOf(WardrobeNode(LARGE))),
                WardrobeNode(MEDIUM))
        )

        assertThat(WardrobeNode.hasChildren(tree)).isTrue()
        assertThat(WardrobeNode.hasChildren(WardrobeNode(MEDIUM))).isFalse()
    }

    // TODO reduce amount of iterations over lists
    // TODO prices
}
