package com.kata

class Ohce {
    fun reverseWord(word: String): String {
        return word.reversed()
    }

    fun isPalindrome(word: String): Boolean{
        return word == reverseWord(word)
    }
}
