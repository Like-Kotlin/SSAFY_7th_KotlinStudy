package m3w12

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main(){

    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())

    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()

    val map = Array(n+1){IntArray(n+1)}
    val dp = Array(n+1){IntArray(n+1)}

   for(i in 1..n){
       st = StringTokenizer(br.readLine())
       for(j in 1..n){
           map[i][j] = st.nextToken().toInt()
       }
   }

    for(i in 1..n){
        for(j in 1..n){
            dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + map[i][j]
        }
    }

    repeat(m){

        st = StringTokenizer(br.readLine())

        val x1 = st.nextToken().toInt()
        val y1 = st.nextToken().toInt()
        val x2 = st.nextToken().toInt()
        val y2 = st.nextToken().toInt()

        println(dp[x2][y2] - dp[x2][y1-1] - dp[x1-1][y2] + dp[x1-1][y1-1])

    }


}