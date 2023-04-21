package com.kata

import java.time.Instant
import java.time.ZoneOffset

class Ohce {

    internal var name = ""
    fun generateOutput(input: String, currentTime: Instant): Pair<String, Boolean> {
        return when {
            input.startsWith("ohce ") -> Pair(greeting(input.split(" ")[1], currentTime), true)
            input == "Stop!" -> Pair(goodBye(), false)
            isPalindrome(input) -> Pair("${input}\n¡Bonita palabra!", true)
            else -> Pair(reverseWord(input), true)
        }
    }
    private fun reverseWord(word: String) = word.reversed()

    private fun isPalindrome(word: String) = word == reverseWord(word)

    private fun greeting(name: String, currentTime: Instant): String {
        this.name = name
        val hour = currentTime.atZone(ZoneOffset.UTC).hour
        return when {
            hour < 6 -> "¡Buenas noches $name!"
            hour in 6..11 -> "¡Buenos días $name!"
            hour >= 20 -> "¡Buenas noches $name!"
            else -> "¡Buenas tardes $name!"
        }
    }

    private fun goodBye() = "Adios $name"

}

fun main() {
    val ohce = Ohce()
    var continueLoop = true
    while (continueLoop) {
        val lineOfText = readLine()
        val output = ohce.generateOutput(lineOfText!!, Instant.now())
        println(output.first)
        continueLoop = output.second
    }
}
