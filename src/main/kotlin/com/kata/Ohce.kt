package com.kata

class Ohce {
    private fun reverseWord(word: String): String {
        return word.reversed()
    }

    fun isPalindrome(word: String): Boolean{
        return word == reverseWord(word)
    }

    private fun greeting(name: String): String {
        return "¡Buenos días $name!"
    }

    fun generateOutput(input: String): String {

        return if (input.startsWith("ohce "))
            greeting(input.split(" ")[1])
        else if(isPalindrome(input)) "${input}\n¡Bonita palabra!"
            else reverseWord(input)
    }
}
