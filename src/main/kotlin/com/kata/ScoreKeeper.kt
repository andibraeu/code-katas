package com.kata

class ScoreKeeper {
    fun getScore(): String {
        val scoreTeamA = formatScore(0)
        val scoreTeamB = formatScore(0)
        return "$scoreTeamA:$scoreTeamB"
    }

    private fun formatScore(score: Int): String {
        return score.toString().padStart(3, '0')
    }


}