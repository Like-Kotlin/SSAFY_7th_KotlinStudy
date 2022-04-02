import java.io.*
import java.util.*
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

lateinit var arr:Array<Array<Int>>
fun main(){
    var br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())
    var N = st.nextToken().toInt()
    var M = st.nextToken().toInt()

    var arr = Array(N+1){Array(N+1){0} }
    repeat(M){
        st = StringTokenizer(br.readLine())
        var start = st.nextToken().toInt()
        var end = st.nextToken().toInt()

        arr[start][end] = 1
    }

    var dp = Array(N+1){1}
    for(i in 1..N){
        for(j in 1 until i){
            // 1~N까지 순서대로 움직이며, i<j 라는 조건을 가지고 있기에 앞에서부터 순회하여 개수를 셀 수 있음
            if(arr[j][i]==1){
                dp[i] = Math.max(dp[i],dp[j]+1)
            }
        }
    }

    for(i in 1..N){
        print("${dp[i]} ")
    }
}
