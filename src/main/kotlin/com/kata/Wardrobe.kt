package com.kata

import com.kata.Size.TINY

class Wardrobe {
    fun getAll250CmCombinations(): List<List<Size>> {
        val resultList = mutableListOf<List<Size>>()

        Size.values().forEach {
            val (totalSize, candidate) = findCandidate(it)

            if (totalSize == 250) {
                resultList.add(candidate)
            }
        }

        return resultList
    }

    private fun findCandidate(size: Size): Pair<Int, List<Size>> {
        val candidate = mutableListOf<Size>()

        candidate.add(size)
        var totalSize = candidate.sumBy { it.size }

        while (totalSize < 250) {
            candidate.add(TINY)
            totalSize = candidate.sumBy { it.size }
        }
        return totalSize to candidate
    }

    // maybe a simple recursion is not the right approach. We might need a tree that represents all candidates.
    private fun recursion(candidate: List<Size>): List<Size>? {
        var totalSize = candidate.sumBy { it.size }
        if (totalSize > 250) return null
        else if (totalSize == 250) return candidate
        else return recursion(candidate + Size.MEDIUM)
    }

    fun createTree(): WardrobeNode {
        return WardrobeNode(null, createWardrobeBranches(0))
    }

    fun findLeafNodePaths(
        node: WardrobeNode,
        result: MutableList<List<Size?>>,
        path: MutableList<Size?>): MutableList<List<Size?>> {
        path.add(node.value)
        if (!WardrobeNode.hasChildren(node)) { // leaf node
            result.add(path.map { it }) // add path to the result
            path.removeLast()
        } else {
            for (child in node.children) {
                findLeafNodePaths(child, result, path)
            }
            path.removeLast()
        }
        return result
    }

    private fun createWardrobeBranches(depth: Int): List<WardrobeNode> {
        return depth
            .takeIf { it == 5 }
            ?.let { emptyList() }
            ?: Size.values().map { WardrobeNode(it, createWardrobeBranches(depth + 1)) }
    }
}

enum class Size(val size: Int, val price: Int) {
    TINY(50, 59),

    SMALL(75, 62),
    MEDIUM(100, 90),
    LARGE(120, 111)
}

// 50 50 50 50 50
// 100 50 50 50
// 100 100 50


