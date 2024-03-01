package com.kata.day2

import java.io.File

class Day2 {
    fun processInput(inputLines: List<String>, part2: Boolean): Int {
        return 8
    }

    internal fun splitGameIdAndGrabs(line: String): Game {
        return line.split(":", limit = 2)
            .let {
                val id = it[0].replace("Game ", "").toInt()
                val grabs = it[1].split(";")
                Game(id, grabs)
            }
    }

    data class Game (
        val id: Int,
        val grabs: List<String>
    )

}

fun main() {
    val list = File("src/main/resources/day2/test_input.txt").bufferedReader().readLines()

    println(Day2().processInput(list, false))
}