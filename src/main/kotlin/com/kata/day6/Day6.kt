package com.kata.day5

import java.io.File
import kotlin.math.ceil
import kotlin.math.pow
import kotlin.math.sqrt

/*

0 1 2  3  4  5  6 7
0 6 10 12 12 10 6 0

f(1) = 1 * (7 - 1)
f(2) = 2 * (7 - 2)
f(x) = x * (7 - x) = 7x - x²

9 = 7x - x²

0 = 7x - x² - 9
- x² +7x -9
0 = x² - 7x + 9

0 = x² - time*x + distance

pq-Formel:
7÷2 − √(3,5^2 − 9) = 1,7
7÷2 + √(3,5^2 − 9) = 5,3


 - time/2 + √((time / 2)^2 − distance)

 - time/2 - √((time / 2)^2 − distance)

*/

class Day6 {

    fun processInput(inputLines: List<String>, part2: Boolean = false): Long {
        return 0
    }

    fun calculateZeroPoints(time: Int, distance: Int): IntRange {
        val pqMinus = pqMinus(time, distance)
        val first = ceil(pqMinus).toInt()
        println("Minus $pqMinus")

        val pqPlus = pqPlus(time, distance)
        println("Plus $pqPlus")
        val second: Int = pqPlus.toInt()

        return first..second
    }

    private fun pqPlus(time: Int, distance: Int) = (time / 2.0) + sqrt((time / 2.0).pow(2) - distance)

    private fun pqMinus(time: Int, distance: Int) = (time / 2.0) - sqrt((time / 2.0).pow(2) - distance)
}


fun main() {
    val list = File("src/main/resources/day6/evas_input.txt").bufferedReader().readLines()

    println(Day6().processInput(list, true))
}
