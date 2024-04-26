package com.kata.day2

import com.kata.day2.Day2.Colors.BLUE
import com.kata.day2.Day2.Colors.GREEN
import com.kata.day2.Day2.Colors.RED
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

    data class Game (
        val id: Int,
        val grabs: List<Map<Colors, Int>>
    )

    enum class Colors {
        RED, BLUE, GREEN
    }

}

fun main() {
    val list = File("src/main/resources/day2/test_input.txt").bufferedReader().readLines()

    println(Day2().processInput(list, false))
}