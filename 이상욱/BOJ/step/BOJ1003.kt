package level15

import java.io.BufferedReader
import java.io.InputStreamReader


class Cnt(var zero: Int, var one: Int) {

    override fun toString(): String {
        return "$zero $one"
    }

}

fun main() {



    val br = BufferedReader(InputStreamReader(System.`in`))
    val T = br.readLine().toInt()


    for (i in 0 until T) {

        val n = br.readLine().toInt()

        val dp : Array<Cnt?> = arrayOfNulls(n+1)

        dp[0] = Cnt(1, 0)

        if (n == 0) {
            println(dp[0])

        } else {

            dp[1] = Cnt(0, 1)

            if (n == 1) {
                println(dp[n])

            } else {

                for (j in 2 until dp.size) {
                    dp[j] = Cnt(
                        dp[j - 2]!!.zero + dp[j - 1]!!.zero,
                        dp[j - 2]!!.one + dp[j - 1]!!.one
                    )
                }
                println(dp[n])
            }
        }
    }
}
