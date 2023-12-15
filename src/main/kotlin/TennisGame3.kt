class TennisGame3(private val p1N: String, private val p2N: String) : TennisGame {

    private var p2: Int = 0
    private var p1: Int = 0
    private val p = mapOf(
        0 to "Love",
        1 to "Fifteen",
        2 to "Thirty",
        3 to "Forty")

    override fun getScore(): String {
        return if (p1 < 4 && p2 < 4 && (p1 != 3 || p2 != 3)) {
            if (p1 == p2) "${p[p1]}-All" else "${p[p1]}-${p[p2]}"
        } else if (p1 == p2)
            "Deuce"
        else {
            val playerName = if (p1 > p2) p1N else p2N
            if ((p1 - p2) * (p1 - p2) == 1) "Advantage $playerName" else "Win for $playerName"
        }
    }

    override fun wonPoint(playerName: String) {
        if (playerName === p1N)
            this.p1 += 1
        else
            this.p2 += 1

    }



}
