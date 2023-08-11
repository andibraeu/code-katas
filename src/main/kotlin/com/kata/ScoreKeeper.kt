package com.kata

class ScoreKeeper {

    private var scoreTeamA = 0

    fun scoreTeamA1() {
        scoreTeamA += 1
    }

    fun scoreTeamA2() {
        scoreTeamA += 2
    }

    fun scoreTeamA3() {
        scoreTeamA += 3
    }

    fun getScore(): String {
        val scoreTeamA = formatScore(scoreTeamA)
        val scoreTeamB = formatScore(0)
        return "$scoreTeamA:$scoreTeamB"
    }

    private fun formatScore(score: Int): String {
        return score.toString().padStart(3, '0')
    }


}
