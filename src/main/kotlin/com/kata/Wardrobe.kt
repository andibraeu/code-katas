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

    fun createTree(): WardrobeNode {
        return WardrobeNode(null, createWardrobeBranches(0))
    }

    fun findAllCandidates(
            node: WardrobeNode,
            result: MutableList<List<Size?>>): Set<List<Size?>> =
            findPaths(mutableListOf(), node, result)
                    .map { path -> path.filterNotNull().sortedBy { it.size } }
                    .toSet()

    private fun findPaths(path: MutableList<Size?>, node: WardrobeNode, result: MutableList<List<Size?>>): MutableList<List<Size?>> {
        path.add(node.value)
        if (!WardrobeNode.hasChildren(node)) { // leaf node
            result.add(path.map { it }) // add path to the result
            path.removeLast()
        } else {
            for (child in node.children) {
                findPaths(path, child, result)
            }
            path.removeLast()
        }
        return result
    }

    private fun createWardrobeBranches(depth: Int): List<WardrobeNode> =
            emptyList<WardrobeNode>()
                    .takeIf { depth == 5 }
                    ?: Size.values().map { WardrobeNode(it, createWardrobeBranches(depth + 1)) }
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


