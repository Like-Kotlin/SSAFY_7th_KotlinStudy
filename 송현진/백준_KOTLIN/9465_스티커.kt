import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    var br = BufferedReader(InputStreamReader(System.`in`))
    var T = br.readLine().toInt()

    for(i in 0 until T){
        var N = br.readLine().toInt()

        var arr = Array(2){ Array(N+1){0} }
        var dp = Array(2){ Array(N+1){0} }

        for(j in 0 until 2){
            var st = StringTokenizer(br.readLine()," ")

            for(k in 1..N){
                arr[j][k] = st.nextToken().toInt()
            }
        }

        dp[0][1] = arr[0][1]
        dp[1][1] = arr[1][1]

        //dp로 0번 줄에 있다면 1번줄의 +1,+2번을 확인한다.
        for(j in 2..N){
            dp[0][j] = Math.max(dp[1][j-1], dp[1][j-2]) + arr[0][j];
            dp[1][j] = Math.max(dp[0][j-1], dp[0][j-2]) + arr[1][j];
        }

        var answer = Math.max(dp[0][N], dp[1][N])
        println(answer)
    }

}