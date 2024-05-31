package com.kata.day2

import com.kata.day2.Day2.Colors.BLUE
import com.kata.day2.Day2.Colors.GREEN
import com.kata.day2.Day2.Colors.RED
import java.io.File

class Day2 {
    fun processInput(inputLines: List<String>, part2: Boolean): Int = inputLines
        .map { splitGameIdAndGrabs(it) }
        .map { it.id to it.grabs.all { map -> isValidGrab(map) } }
        .filter { it.second }
        .sumOf { it.first }

    internal fun splitGameIdAndGrabs(line: String): Game {
        return line.split(":", limit = 2)
            .let {
                val id = it[0].replace("Game ", "").toInt()
                val grabs = it[1].split(";")
                Game(id, getColorsAndNumbers(grabs))
            }
    }

    internal fun getColorsAndNumbers(grabs: List<String>): List<Map<Colors, Int>> {
        return grabs.map { grab ->
            grab.split(",")
                .associate {
                    val split = it.trim().split(" ")
                    mapColor(split[1]) to split[0].toInt()
                }
        }
    }

    private fun mapColor(colorString: String): Colors {
        return when (colorString.lowercase()) {
            "red" -> RED
            "green" -> GREEN
            "blue" -> BLUE
            else -> throw RuntimeException("Unknown color")
        }
    }

    fun isValidGrab(grab: Map<Colors, Int>): Boolean =
        Colors.entries.none { (grab[it] ?: 0) > it.maxSize }

    data class Game (
        val id: Int,
        val grabs: List<Map<Colors, Int>>
    )

    enum class Colors(val maxSize: Int) {
        RED(12), GREEN(13), BLUE(14)
    }

}

fun main() {
    val list = File("src/main/resources/day2/test_input.txt").bufferedReader().readLines()

    println(Day2().processInput(list, false))
}
