package level15

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))

    val N = br.readLine().toInt()

    val dp = IntArray(N+1)

    dp.fill(Integer.MAX_VALUE)

    dp[1] = 0


    for (i in 2 until  dp.size){

        if(i % 3 ==0){
            dp[i] = (dp[i / 3] + 1).coerceAtMost(dp[i])
        }

        if(i % 2 ==0){
            dp[i] = (dp[i / 2] + 1).coerceAtMost(dp[i])
        }

        dp[i] = dp[i].coerceAtMost(dp[i - 1] + 1)

    }

    println(dp[N])


}