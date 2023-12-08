class TennisGame2(private val player1Name: String, private val player2Name: String) : TennisGame {
    var p1point: Int = 0
    var p2point: Int = 0

    override fun getScore(): String {
        return when {
            p1point >= 4 && p2point >= 0 && p1point - p2point >= 2 ->
                "Win for $player1Name"

            p2point >= 4 && p1point >= 0 && p2point - p1point >= 2 ->
                "Win for $player2Name"

            p1point == p2point && p1point >= 3 ->
                "Deuce"

            p1point == p2point ->
                "${resolvePointsToNames(p1point)}-All"

            p1point < 4 && p2point < 4 ->
                "${resolvePointsToNames(p1point)}-${resolvePointsToNames(p2point)}"

            p1point > p2point && p2point >= 3 ->
                "Advantage $player1Name"

            p2point > p1point && p1point >= 3 ->
                "Advantage $player2Name"

            else -> ""
        }
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
