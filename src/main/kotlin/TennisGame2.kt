class TennisGame2(private val player1Name: String, private val player2Name: String) : TennisGame {
    var p1point: Int = 0
    var p2point: Int = 0

    var p1res: String = ""
    var p2res: String = ""

    override fun getScore(): String {
        var score = ""
        if (p1point == p2point && p1point < 4) {
            when (p1point) {
                0 -> score = "Love"
                1 -> score = "Fifteen"
                2 -> score = "Thirty"
            }
            score += "-All"
        }
        if (p1point == p2point && p1point >= 3)
            score = "Deuce"

        if (p1point > 0 && p2point == 0) {
            p1res = resolvePointsToNames(p1point)

            p2res = "Love"
            score = "$p1res-$p2res"
        }
        if (p2point > 0 && p1point == 0) {
            when (p2point) {
                1 -> p2res = "Fifteen"
                2 -> p2res = "Thirty"
                3 -> p2res = "Forty"
            }

            p1res = "Love"
            score = "$p1res-$p2res"
        }

        if (p1point > p2point && p1point < 4) {
            when (p1point) {
                2 -> p1res = "Thirty"
                3 -> p1res = "Forty"
            }
            when (p2point) {
                1 -> p2res = "Fifteen"
                2 -> p2res = "Thirty"
            }
            score = "$p1res-$p2res"
        }
        if (p2point > p1point && p2point < 4) {
            when (p2point) {
                2 -> p2res = "Thirty"
                3 -> p2res = "Forty"
            }
            when (p1point) {
                1 -> p1res = "Fifteen"
                2 -> p1res = "Thirty"
            }
            score = "$p1res-$p2res"
        }

        if (p1point > p2point && p2point >= 3) {
            score = "Advantage $player1Name"
        }

        if (p2point > p1point && p1point >= 3) {
            score = "Advantage $player2Name"
        }

        if (p1point >= 4 && p2point >= 0 && p1point - p2point >= 2) {
            score = "Win for $player1Name"
        }
        if (p2point >= 4 && p1point >= 0 && p2point - p1point >= 2) {
            score = "Win for $player2Name"
        }
        return score
    }

    private fun resolvePointsToNames(point: Int): String {
        return when (point) {
            1 -> "Fifteen"
            2 -> "Thirty"
            3 -> "Forty"
            else -> ""
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