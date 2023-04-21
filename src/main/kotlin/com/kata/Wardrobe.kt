package com.kata

import com.kata.Size.TINY

class Wardrobe {
    fun getAll250CmCombinations(): List<List<Size>> {
        val resultList = mutableListOf<List<Size>>()
        val candidate = mutableListOf<Size>()

        candidate.add(TINY)
        var totalSize = candidate.sumBy { it.size }

        while (totalSize < 250) {
            candidate.add(TINY)
            totalSize = candidate.sumBy { it.size }
        }

        if (totalSize == 250) {
            resultList.add(candidate)
        }

        return resultList
    }
}

enum class Size(val size: Int, val price: Int) {
    TINY(50, 59),
    SMALL(75, 62),
    MEDIUM(100, 90),
    LARGE(120, 111)
}
