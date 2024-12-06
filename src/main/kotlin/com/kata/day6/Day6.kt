package com.kata.day5

import java.io.File
import java.util.stream.Collectors.toList

class Day6 {

    fun processInput(inputLines: List<String>, part2: Boolean = false): Long {
        return 0
    }
}


fun main() {
    val list = File("src/main/resources/day6/evas_input.txt").bufferedReader().readLines()

    println(Day6().processInput(list, true))
}
