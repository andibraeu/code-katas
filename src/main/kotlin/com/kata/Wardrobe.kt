package com.kata

import com.kata.Size.TINY

class Wardrobe {
    fun getAll250CmCombinations() :List<List<Size>> = listOf(listOf(TINY, TINY, TINY, TINY, TINY))
}

enum class Size (val size: Int, val price: Int){
    TINY(50, 59),
    SMALL(75, 62),
    MEDIUM(100, 90),
    LARGE(120, 111)
}
