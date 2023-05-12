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


    private fun recursion(candidate: List<Size>): List<Size>? {
        var totalSize = candidate.sumBy { it.size }
        if (totalSize > 250) return null
        else if (totalSize == 250) return candidate
        else return recursion(candidate + Size.MEDIUM)
    }
}

enum class Size(val size: Int, val price: Int) {
    TINY(50, 59),

    //    SMALL(75, 62),
    MEDIUM(100, 90),
    LARGE(120, 111)
}

// 50 50 50 50 50
// 100 50 50 50
// 100 100 50


