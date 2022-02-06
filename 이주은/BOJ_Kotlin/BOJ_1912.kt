import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*


fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    var n = readLine().toInt()
    var max = 0

    var dp = IntArray(n){Int.MIN_VALUE}
    var arr = IntArray(n)

    var st = StringTokenizer(readLine())

    for(i in 0 until n){
        arr[i] = st.nextToken().toInt()
    }

    dp[0] = arr[0]
    max = arr[0]

    for(i in 1 until n){
        var num = dp[i - 1] + arr[i]
        dp[i] = Math.max(num, arr[i])
        max = Math.max(max, dp[i])
    }

    println(max)

}