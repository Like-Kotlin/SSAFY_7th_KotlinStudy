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

    arr = Array(N+1){Array(N+1){0} }
    for(i in 1 .. N){
        st = StringTokenizer(br.readLine())
        for(j in 1.. N){
            arr[i][j] = st.nextToken().toInt()
        }
    }

    for(middle in 1..N){
        for(start in 1..N){
            for(end in 1..N){
                arr[start][end] = Math.min(arr[start][end], arr[start][middle]+arr[middle][end])
            }
        }
    }

    var sb = StringBuilder()
    for(i in 1..M){
        st = StringTokenizer(br.readLine())
        var start = st.nextToken().toInt()
        var end = st.nextToken().toInt()
        var time = st.nextToken().toInt()

        if(arr[start][end] <= time){
            sb.append("Enjoy other party\n")
        }else{
            sb.append("Stay here\n")
        }
    }
    print(sb)
}
