package com.kata.day3

import java.io.File

class Day3 {

    fun processInput(inputLines: List<String>, part2: Boolean = false): Int {
        return 5
    }

}

fun main() {
    val list = File("src/main/resources/day3/test_input.txt").bufferedReader().readLines()

    println(Day3().processInput(list, false))
}

