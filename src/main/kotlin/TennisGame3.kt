class TennisGame3(private val p1N: String, private val p2N: String) : TennisGame {

    private var p2: Int = 0
    private var p1: Int = 0

    override fun getScore(): String {
        if (p1 < 4 && p2 < 4 && (p1 != 3 || p2 != 3)) {
            val pointExpression: String
            val p = arrayOf("Love", "Fifteen", "Thirty", "Forty")
            pointExpression = p[p1]
            return if (p1 == p2) "$pointExpression-All" else "$pointExpression-${p[p2]}"
        } else {
            if (p1 == p2)
                return "Deuce"
            val playerName = if (p1 > p2) p1N else p2N
            return if ((p1 - p2) * (p1 - p2) == 1) "Advantage $playerName" else "Win for $playerName"
        }
    }

    override fun wonPoint(playerName: String) {
        if (playerName === p1N)
            this.p1 += 1
        else
            this.p2 += 1

    }

}
