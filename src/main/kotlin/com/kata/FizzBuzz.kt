package com.kata

class FizzBuzz {

    fun printNumbers(): List<String> {
        return (1..100)
                .map {
                    if ( it % 3 == 0 ) {
                        "kuksa"
                    } else if ( it == 5) {
                        "sauna"
                    }
                    else it.toString()
                }
    }
}