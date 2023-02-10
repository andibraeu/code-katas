package com.kata

class FizzBuzz {

    fun printNumbers(): List<String> {
        return (1..100)
                .map {
                    if ( it % 15 == 0) {
                        "dip"
                    } else if ( it % 3 == 0 ) {
                        "kuksa"
                    } else if ( it %5  == 0) {
                        "sauna"
                    }
                    else it.toString()
                }
    }
}