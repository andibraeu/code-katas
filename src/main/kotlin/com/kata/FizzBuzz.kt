package com.kata

class FizzBuzz {

    fun printNumbers(): List<String> {
        return (1..100).map {
            it.toString()
        }
    }
}