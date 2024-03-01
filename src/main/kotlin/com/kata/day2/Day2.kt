package com.kata.day2

import java.io.File

class Day2 {
    fun processInput(inputLines: List<String>, part2: Boolean): Int {
        return 8
    }

}

fun main() {
    val list = File("src/main/resources/day2/test_input.txt").bufferedReader().readLines()

    println(Day2().processInput(list, false))
}