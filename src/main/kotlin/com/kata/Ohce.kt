package com.kata

class Ohce {
    fun generateOutput(input: String): String {
        return if (input.startsWith("ohce "))
            greeting(input.split(" ")[1])
        else if(isPalindrome(input)) "${input}\n¡Bonita palabra!"
        else reverseWord(input)
    }
    private fun reverseWord(word: String) = word.reversed()

    private fun isPalindrome(word: String) = word == reverseWord(word)

    private fun greeting(name: String) = "¡Buenos días $name!"


}
