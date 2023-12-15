class TennisGame3(private val p1N: String, private val p2N: String) : TennisGame {

    private var p2: Int = 0
    private var p1: Int = 0
    private val pointToNames = mapOf(
        0 to "Love",
        1 to "Fifteen",
        2 to "Thirty",
        3 to "Forty")

    override fun getScore(): String {
        return when {
            p1 == p2 && p1 < 3 -> "${pointToNames[p1]}-All"
            p1 < 4 && p2 < 4 && (p1 != 3 || p2 != 3) -> "${pointToNames[p1]}-${pointToNames[p2]}"
            p1 == p2 -> "Deuce"
            else -> if (isAdvantage(p1, p2)) "Advantage ${getPlayerName(p1, p2)}" else "Win for ${getPlayerName(p1, p2)}"
        }
    }

    private fun isAdvantage(p1: Int, p2: Int) = (p1 - p2) * (p1 - p2) == 1

    private fun getPlayerName(pointsPlayer1: Int, pointsPlayer2: Int) = if (pointsPlayer1 > pointsPlayer2) p1N else p2N

    override fun wonPoint(playerName: String) {
        if (playerName === p1N)
            this.p1 += 1
        else
            this.p2 += 1

    }



}
