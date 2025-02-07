package com.kata.day7

import com.kata.day7.Types.FIVE_OF_A_KIND
import com.kata.day7.Types.FOUR_OF_A_KIND
import com.kata.day7.Types.FULL_HOUSE
import com.kata.day7.Types.HIGH_CARD
import com.kata.day7.Types.ONE_PAIR
import com.kata.day7.Types.THREE_OF_A_KIND
import com.kata.day7.Types.TWO_PAIR
import java.io.File

/*


*/

class Day7 {

    fun processInput(inputLines: List<String>, part2: Boolean = false): Int {
        return 0
    }

    fun evaluateHand(hand: List<Cards>): Types {
        val result = hand.groupingBy { it }.eachCount()

        return when {
            result.size == 1 -> FIVE_OF_A_KIND
            result.size == 2 && result.filter { it.value == 4 }.isNotEmpty() -> FOUR_OF_A_KIND
            result.size == 2 -> FULL_HOUSE
            result.size == 3 && result.filter { it.value == 3 }.isNotEmpty() -> THREE_OF_A_KIND
            result.size == 3 -> TWO_PAIR
            result.size == 4 -> ONE_PAIR
            else -> HIGH_CARD
        }
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
