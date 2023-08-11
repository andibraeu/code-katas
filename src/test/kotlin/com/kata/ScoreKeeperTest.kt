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

    @Test
    fun addOnePointForTeamA() {
        val scoreKeeper = ScoreKeeper()

        scoreKeeper.scoreTeamA1()
        val score = scoreKeeper.getScore()

        assertThat(score).isEqualTo("001:000")
    }

    @Test
    fun addTwoPointsForTeamA() {
        val scoreKeeper = ScoreKeeper()

        scoreKeeper.scoreTeamA2()
        val score = scoreKeeper.getScore()

        assertThat(score).isEqualTo("002:000")
    }

    @Test
    fun addThreePointsForTeamA() {
        val scoreKeeper = ScoreKeeper()

        scoreKeeper.scoreTeamA3()
        val score = scoreKeeper.getScore()

        assertThat(score).isEqualTo("003:000")
    }
}
