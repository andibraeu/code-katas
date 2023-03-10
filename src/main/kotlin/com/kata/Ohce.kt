package com.kata

class Ohce {

    internal var name = ""
    fun generateOutput(input: String): Pair<String, Boolean> {
        return when {
            input.startsWith("ohce ") -> Pair(greeting(input.split(" ")[1]), true)
            input == "Stop!" -> Pair(goodBye(), false)
            isPalindrome(input) -> Pair("${input}\n¡Bonita palabra!", true)
            else -> Pair(reverseWord(input), true)
        }
    }
    private fun reverseWord(word: String) = word.reversed()

    private fun isPalindrome(word: String) = word == reverseWord(word)

    private fun greeting(name: String): String {
        this.name = name
        return "¡Buenos días $name!"
    }

    private fun goodBye() = "Adios $name"

}

fun main() {
    val ohce = Ohce()
    var continueLoop = true
    while (continueLoop) {
        val lineOfText = readLine()
        val output = ohce.generateOutput(lineOfText!!)
        println(output.first)
        continueLoop = output.second
    }
}