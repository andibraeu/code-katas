package com.kata

class FizzBuzz {

    fun printNumbers(max: Int): List<String> {
        return (1..max)
                .map {
                    if (it % 15 == 0) {
                        "dip"
                    } else if (it % 3 == 0) {
                        "kuksa"
                    } else if (it % 5 == 0) {
                        "sauna"
                    } else it.toString()
                }
    }
}

fun main() {
    FizzBuzz().printNumbers(1000).map { println(it) }
}