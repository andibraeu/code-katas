package com.kata.day7

import java.io.File

/*


*/

class Day7 {

    fun processInput(inputLines: List<String>, part2: Boolean = false): Int {
        return 0
    }

    fun evaluateHand(hand: List<Cards>): Types {
        return Types.TWO_PAIR
    }


}

enum class Cards(value: String, sortOrder: Int) {
    A("A", 14),
    K("K", 13),
    Q("Q", 12),
    J("J", 11),
    TEN("T", 10),
    NINE("9", 9),
    EIGHT("8", 8),
    SEVEN("7", 7),
    SIX("6", 6),
    FIVE("5", 5),
    FOUR("4", 4),
    THREE("3", 3),
    TWO("2", 2)
}

enum class Types(sortOrder: Int) {
    FIVE_OF_A_KIND(7),
    FOUR_OF_A_KIND(6),
    FULL_HOUSE(5),
    THREE_OF_A_KIND(4),
    TWO_PAIR(3),
    ONE_PAIR(2),
    HIGH_CARD(1)
}


fun main() {
    val list = File("src/main/resources/day7/test_input.txt").bufferedReader().readLines()

    println(Day7().processInput(list, true))
}
