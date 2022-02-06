import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    var st = StringTokenizer(readLine())
    var n = st.nextToken().toInt()
    var r = st.nextToken().toInt()

    var dp = Array<Array<Int>>(n + 1){Array<Int>(r + 1, {1})}

    for(i in 1..n){
        for(j in 1..r){
            if(i == j)
                dp[i][j] = 1
            else
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j]

            dp[i][j] %= 10007
        }
    }

    println(dp[n][r])

}