package com.kata.day5

import com.kata.day4.Day4
import java.io.File

class Day5 {

    fun processInput(inputLines: List<String>, part2: Boolean = false): Int {
        return 0
    }

    fun readSeeds(input: List<String>): List<Int> {
        return input.first()
            .split(" ")
            .filter { it != "seeds:" }
            .map { it.toInt() }
    }

    fun readMaps(input: List<String>): List<List<MapEntry>> {
        val mapsOnly = input
            .filter { !it.startsWith("seeds:") }
        val result = mutableListOf<MutableList<MapEntry>>()
        var key = ""

        mapsOnly.forEach { line ->
            if (line.endsWith("map:")) {
                key = line.split(" ")[0]
                result.add(mutableListOf())
            } else {
                if (line != "") result.last().add(convertToMapEntry(line))
            }
        }
        return result
    }

    fun convertToMapEntry(entry: String): MapEntry {
        val split = entry.split(" ").map { it.toInt() }

        val endRange = split[1] + split[2] - 1
        return MapEntry(split[1]..endRange, split[0] - split[1])
    }

    fun getSoilFromSeed(input: Int, seedToSoilMapEntries: List<MapEntry>): Int {
        return seedToSoilMapEntries.firstOrNull {
            input in it.range
        }?.let {
            input + it.offset
        }?: input
    }

    fun walkThroughMaps(seed: Int, input: List<List<MapEntry>>): Int {
        var result = seed
        input.forEach {
            result = getSoilFromSeed(result, it)
        }
        return result
    }
}

data class MapEntry(
    val range: IntRange,
    val offset: Int
)

fun main() {
    val list = File("src/main/resources/day4/test_input.txt").bufferedReader().readLines()

    println(Day4().processInput(list, true))
}
