package com.kata

class ScoreKeeper {

    private var scoreTeamA = 0
    private var scoreTeamB = 0

    fun scoreTeamA1() {
        scoreTeamA += 1
    }

    fun scoreTeamA2() {
        scoreTeamA += 2
    }

    fun scoreTeamA3() {
        scoreTeamA += 3
    }

    fun scoreTeamB1() {
        scoreTeamB += 1
    }

    fun scoreTeamB2() {
        scoreTeamB += 2
    }

    fun scoreTeamB3() {
        scoreTeamB += 3
    }

    fun getScore(): String {
        val scoreTeamA = formatScore(scoreTeamA)
        val scoreTeamB = formatScore(scoreTeamB)
        return "$scoreTeamA:$scoreTeamB"
    }

    private fun formatScore(score: Int): String {
        return score.toString().padStart(3, '0')
    }


}
