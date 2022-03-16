package m3w11

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

var n = 0
lateinit var arr : LongArray
lateinit var dp : LongArray
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    n = br.readLine().toInt()
    arr = LongArray(n)
    dp = LongArray(n)

    val st = StringTokenizer(br.readLine())
    repeat(n){ i ->
        arr[i] = st.nextToken().toLong()
        dp[i] = -1
    }

    println(cross(0))
    

}

fun cross(x: Int): Long {

    if( x == n-1){
        return 0
    }

    if(dp[x] != -1L){
        return dp[x]
    }

    dp[x] = Long.MAX_VALUE

    for(i in x+1 until n){
        dp[x] = Math.min(dp[x] , Math.max(cross(i), (i - x) * (1 + Math.abs(arr[x] - arr[i]))))
    }
    return dp[x]

}
