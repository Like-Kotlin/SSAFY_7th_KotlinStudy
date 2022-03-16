package `11주차`

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

lateinit var dp: LongArray
lateinit var arr: LongArray

fun main()=with(BufferedReader(InputStreamReader(System.`in`))){
    val n = readLine().toInt()
    arr = LongArray(n)
    dp = LongArray(n, { -1 })

    var st = StringTokenizer(readLine())
    for(i in 0 until n){
        arr[i] = st.nextToken().toLong()
    }

    var result = go(0, n)

    println(result)

}

fun go(x: Int, n: Int): Long {
    if(x == n - 1)
        return 0;
    if(dp[x] != -1L)
        return dp[x]

    dp[x] = Long.MAX_VALUE
    for(i in x + 1 until n){
        dp[x] = Math.min(dp[x], Math.max(go(i, n), (i - x) * (1 + Math.abs(arr[x] - arr[i]))))
    }

    return dp[x]
}
