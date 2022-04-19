package m4w11

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

var n = 0
lateinit var dp: Array<IntArray>
lateinit var stickers: Array<IntArray>

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st: StringTokenizer

    val tc = br.readLine().toInt()
    repeat(tc) {
        n = br.readLine().toInt()
        dp = Array(2) { IntArray(n + 1) }
        stickers = Array(2) { IntArray(n + 1) }

        for (i in 0 until 2) {
            st = StringTokenizer(br.readLine())
            for (j in 1 until n + 1) {
                stickers[i][j] = st.nextToken().toInt()
            }
        }

        dp[0][1] = stickers[0][1]
        dp[1][1] = stickers[1][1]

        for (i in 2 until n + 1) {
            dp[0][i] = Math.max(dp[1][i - 1], dp[1][i - 2]) + stickers[0][i]
            dp[1][i] = Math.max(dp[0][i - 1], dp[0][i - 2]) + stickers[1][i]
        }
        println(Math.max(dp[0][n], dp[1][n]))
    }

}
