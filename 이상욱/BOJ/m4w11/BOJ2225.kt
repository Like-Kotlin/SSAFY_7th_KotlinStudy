package m4w11

import java.io.*
import java.util.*

val num = 1000000000

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(br.readLine())

    val n = st.nextToken().toInt()
    val k = st.nextToken().toInt()

    val dp = Array(k+1){IntArray(n+1)}

    Arrays.fill(dp[1],1)

    for(i in 1..k){
        dp[i][0] = 1
    }

    for(i in 2..k){
        for(j in 1..n){
            dp[i][j] = dp[i-1][j] + dp[i][j-1]
            dp[i][j] %= num
        }
    }
    println(dp[k][n])

}