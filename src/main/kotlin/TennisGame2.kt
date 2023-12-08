class TennisGame2(private val player1Name: String, private val player2Name: String) : TennisGame {
    var p1point: Int = 0
    var p2point: Int = 0

    override fun getScore(): String {
        var score = ""

        if (p1point == p2point && p1point >= 3)
            score = "Deuce"
        else if (p1point == p2point) {
            score = "${resolvePointsToNames(p1point)}-All"
        }

        if (p1point < 4 && p2point < 4 && p1point != p2point) {
            score = "${resolvePointsToNames(p1point)}-${resolvePointsToNames(p2point)}"
        }

        if (p1point > p2point && p2point >= 3) {
            score = "Advantage $player1Name"
        } else if (p2point > p1point && p1point >= 3) {
            score = "Advantage $player2Name"
        }

        if (p1point >= 4 && p2point >= 0 && p1point - p2point >= 2) {
            score = "Win for $player1Name"
        } else if (p2point >= 4 && p1point >= 0 && p2point - p1point >= 2) {
            score = "Win for $player2Name"
        }
        return score
    }

    private fun resolvePointsToNames(point: Int): String {
        return when (point) {
            0 -> "Love"
            1 -> "Fifteen"
            2 -> "Thirty"
            else -> "Forty"
        }
    }

    fun setP1Score(number: Int) {
        p1point += number
    }

    fun setP2Score(number: Int) {
        p2point += number
    }

    override fun wonPoint(player: String) {
        if (player === player1Name)
            setP1Score(1)
        else
            setP2Score(1)
    }
}
