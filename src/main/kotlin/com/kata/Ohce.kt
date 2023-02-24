package com.kata

import java.time.Instant

class Ohce {
    fun reverseWord(word: String): String {
        return word.reversed()
    }

    fun isPalindrome(word: String): Boolean{
        return word == reverseWord(word)
    }

    fun greeting(name: String): String {
        return "¡Buenos días $name!"
    }
}
