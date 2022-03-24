import java.io.*
import java.util.*
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

var N = 0
var M = 0
lateinit var arr:Array<Array<Long>>
lateinit var dp:Array<Array<Long>>

fun main(){
    var br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine()," ")
    N = st.nextToken().toInt()
    M = st.nextToken().toInt()
    arr = Array(N+1){Array(N+1){0}}
    dp = Array(N+1){Array(N+1){0}}

    for(i in 1 .. N){
        st = StringTokenizer(br.readLine()," ")
        for(j in 1 .. N){
            arr[i][j] = st.nextToken().toLong()
            dp[i][j] = dp[i][j-1]+dp[i-1][j]+arr[i][j]-dp[i-1][j-1]
        }
    }

    for(i in 1..M){
        st = StringTokenizer(br.readLine()," ")

        var x1 = st.nextToken().toInt()
        var y1 = st.nextToken().toInt()
        var x2 = st.nextToken().toInt()
        var y2 = st.nextToken().toInt()

        var ans = calRectangle(x1,y1,x2,y2)
        println(ans)
    }
}

fun calRectangle(x1:Int, y1:Int, x2:Int, y2:Int):Long {

    if(x1 == x2 && y1 == y2) {
        return arr[x1][y1]
    }

    //세 로
    if(x1 < x2 && y1 == y2){
        return dp[x2][y2]-dp[x1-1][y1]-dp[x2][y2-1]+dp[x1-1][y1-1]
    }

    //가 로
    if(x1 == x2 && y1 < y2){
        return dp[x2][y2]-dp[x2-1][y2]-dp[x1][y1-1]+dp[x1-1][y1-1]
    }

    //전체
    return dp[x2][y2]-dp[x1-1][y2]-dp[x2][y1-1]+dp[x1-1][y1-1]
}