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

    @Test
    fun createTwoCharPointsTeamA() {
        val scoreKeeper = ScoreKeeper()

        scoreKeeper.scoreTeamA3()
        scoreKeeper.scoreTeamA3()
        scoreKeeper.scoreTeamA2()
        scoreKeeper.scoreTeamA3()
        scoreKeeper.scoreTeamA1()
        scoreKeeper.scoreTeamA3()
        val score = scoreKeeper.getScore()

        assertThat(score).isEqualTo("015:000")
    }

    @Test
    fun addOnePointForTeamB() {
        val scoreKeeper = ScoreKeeper()

        scoreKeeper.scoreTeamB1()
        val score = scoreKeeper.getScore()

        assertThat(score).isEqualTo("000:001")
    }

    @Test
    fun addTwoPointsForTeamB() {
        val scoreKeeper = ScoreKeeper()

        scoreKeeper.scoreTeamB2()
        val score = scoreKeeper.getScore()

        assertThat(score).isEqualTo("000:002")
    }

    @Test
    fun addThreePointsForTeamB() {
        val scoreKeeper = ScoreKeeper()

        scoreKeeper.scoreTeamB3()
        val score = scoreKeeper.getScore()

        assertThat(score).isEqualTo("000:003")
    }

    @Test
    fun createTwoCharPointsTeamB() {
        val scoreKeeper = ScoreKeeper()

        scoreKeeper.scoreTeamB3()
        scoreKeeper.scoreTeamB3()
        scoreKeeper.scoreTeamB2()
        scoreKeeper.scoreTeamB3()
        scoreKeeper.scoreTeamB1()
        scoreKeeper.scoreTeamB3()
        val score = scoreKeeper.getScore()

        assertThat(score).isEqualTo("000:015")
    }
}
