package com.kata

class Ohce {

    internal var name = ""
    fun generateOutput(input: String): String {
        return when {
            input.startsWith("ohce ") -> greeting(input.split(" ")[1])
            input == "Stop!" -> goodBye()
            isPalindrome(input) -> "${input}\n¡Bonita palabra!"
            else -> reverseWord(input)
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
    while (true) {
        val readLine = readLine()
        println(ohce.generateOutput(readLine!!))
    }
}