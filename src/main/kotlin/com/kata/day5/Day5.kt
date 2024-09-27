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

    fun readMaps(input: List<String>): Map<String, List<String>> {
        val mapsOnly = input
            .filter { !it.startsWith("seeds:") }
        val result = mutableMapOf<String, MutableList<String>>()
        var key = ""

        mapsOnly.forEach { line->
            if (line.endsWith("map:")) {
                key = line.split(" ")[0]
                result[key] = mutableListOf<String>()
            } else {
                if (line != "") result[key]?.add(line)
            }
        }
        return result
    }
}

fun main() {
    val list = File("src/main/resources/day4/test_input.txt").bufferedReader().readLines()

    println(Day4().processInput(list, true))
}