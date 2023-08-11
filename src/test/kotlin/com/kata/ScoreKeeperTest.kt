package com.kata

import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.api.Test


class ScoreKeeperTest {

    @Test
    fun getInitialScore() {
        val scoreKeeper = ScoreKeeper()

        val score = scoreKeeper.getScore()

        assertThat(score).isEqualTo("000:000")
    }
}