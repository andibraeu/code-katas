class TennisGame1(private val player1Name: String, private val player2Name: String) : TennisGame {

    private var m_score1: Int = 0
    private var m_score2: Int = 0

    override fun wonPoint(playerName: String) {
        if (playerName === player1Name)
            m_score1 += 1
        else
            m_score2 += 1
    }

    override fun getScore(): String {
        var score = ""

        if (m_score1 == m_score2) {
            score = handleEqualScore()
        } else if (m_score1 >= 4 || m_score2 >= 4) {
            score = winOrAdvantage()
        } else {
            score = scoreByPlayer(score)
        }
        return score
    }

    private fun scoreByPlayer(score: String): String {
        var tempScore1: Int
        var score1 = score
        for (i in 1..2) {
            if (i == 1)
                tempScore1 = m_score1
            else {
                score1 += "-"
                tempScore1 = m_score2
            }
            score1 = scoreToName(tempScore1, score1)
        }
        return score1
    }

    private fun scoreToName(tempScore: Int, score1: String): String {
        var score11 = score1
        when (tempScore) {
            0 -> score11 += "Love"
            1 -> score11 += "Fifteen"
            2 -> score11 += "Thirty"
            3 -> score11 += "Forty"
        }
        return score11
    }

    private fun winOrAdvantage(): String {
        val difference = m_score1 - m_score2
        return when {
            difference == 1 -> "Advantage $player1Name"
            difference == -1 -> "Advantage $player2Name"
            difference >= 2 -> "Win for $player1Name"
            else -> "Win for $player2Name"
        }

    }

    private fun handleEqualScore(): String {
        return when (m_score1) {
            0 -> "Love-All"
            1 -> "Fifteen-All"
            2 -> "Thirty-All"
            else -> "Deuce"
        }
    }
}
