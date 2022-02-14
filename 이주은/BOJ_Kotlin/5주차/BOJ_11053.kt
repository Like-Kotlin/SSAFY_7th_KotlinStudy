import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.max

fun main()=with(BufferedReader(InputStreamReader(System.`in`))){
    var n =  readLine().toInt()
    var st = StringTokenizer(readLine())

    var arr = IntArray(n + 1)
    var dp = IntArray(n + 1)
    var ans = 0

    for(i in 1 .. n){
        arr[i] = st.nextToken().toInt()
    }

    dp[1] = 1

    if(n < 2){
        println(dp[1])
        return
    }

    for(i in 2..n){
        var max = 0

        for(j in 1 until i){
            if(max < dp[j] && arr[i] > arr[j])
                max = dp[j]
        }

        dp[i] = max + 1
        ans = max(ans, dp[i])
    }

    println(ans)
}