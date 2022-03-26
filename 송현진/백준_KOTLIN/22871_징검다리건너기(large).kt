import java.io.*
import java.util.*

var N = 0
lateinit var arr:Array<Long>
lateinit var dp:Array<Long>

fun main(){
    var br = BufferedReader(InputStreamReader(System.`in`))
    N = br.readLine().toInt()
    var st = StringTokenizer(br.readLine()," ")

    arr = Array(N){0}
    dp = Array(N){0}

    for(i in 0 until N){
        arr[i] = st.nextToken().toLong()
        dp[i] = -1
    }

    var result = goBridge(0)
    println(result)
}

fun goBridge(start: Int): Long{
    if(start == N-1) return 0
    if(dp[start] != (-1).toLong()) return dp[start]

    dp[start] = Long.MAX_VALUE
    for(i in start+1 .. N-1) {
        println(i)
        dp[start] = Math.min( dp[start] , Math.max(goBridge(i), (i - start) * (1 + Math.abs(arr[start]-arr[i]))))
        println("${i} : ${dp[start]}")
    }

    return  dp[start]
}