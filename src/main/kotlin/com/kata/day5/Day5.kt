package com.kata.day5

import java.io.File
import java.util.stream.Collectors.toList

class Day5 {

    fun processInput(inputLines: List<String>, part2: Boolean = false): Long {
        return readMaps(inputLines)
            .let { maps ->

                if (part2) {
                    readSeedRanges(inputLines).parallelStream()
                        .map { seedRange ->
                            println(seedRange)
                            seedRange.minOfOrNull { walkThroughMaps(it, maps) } ?: 0
                        }.collect(toList())
                        .min()

                } else readSeeds(inputLines).minOfOrNull { walkThroughMaps(it, maps) }
            }
            ?: 0
    }

    fun readSeedRanges(input: List<String>): List<LongRange> {
        val readSeeds = readSeeds(input)

        val listOfRanges = mutableListOf<LongRange>()
        for (i in readSeeds.indices step 2) {
            val longRange = readSeeds[i]..<readSeeds[i] + readSeeds[i + 1]
            listOfRanges.add(longRange)
        }

        return listOfRanges
    }

    fun readSeeds(input: List<String>): List<Long> {
        return input.first()
            .split(" ")
            .filter { it != "seeds:" }
            .map { it.toLong() }
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

    fun walkThroughMaps(seed: Long, input: List<List<MapEntry>>): Long {
        var result = seed
        input.forEach {
            result = getSoilFromSeed(result, it)
        }
        return result
    }

    internal fun convertToMapEntry(entry: String): MapEntry {
        val split = entry.split(" ").map { it.toLong() }

        val endRange = split[1] + split[2] - 1
        return MapEntry(split[1]..endRange, split[0] - split[1])
    }

    internal fun getSoilFromSeed(input: Long, seedToSoilMapEntries: List<MapEntry>): Long {
        return seedToSoilMapEntries.firstOrNull {
            input in it.range
        }?.let {
            input + it.offset
        } ?: input
    }
}

data class MapEntry(
    val range: LongRange,
    val offset: Long
)

fun main() {
    val list = File("src/main/resources/day5/evas_input.txt").bufferedReader().readLines()

    println(Day5().processInput(list, true))
}
