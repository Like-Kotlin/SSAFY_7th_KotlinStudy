import java.util.*
import java.io.*

var N = 0
var M = 0
var sb = StringBuffer("")
fun main() {
    var br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine()," ")

    N = st.nextToken().toInt()
    M = st.nextToken().toInt()

    var arr = Array(M){0}
    backtracking(arr, 0)
    print(sb)
}

fun backtracking(arr: Array<Int>, dept: Int){
    if(dept == M){
        Print(arr)
        return
    }

    for(i in 1..N){
            arr[dept] = i
            backtracking(arr,  dept+1)
    }
}

fun Print(arr: Array<Int>){
    for(element in arr){
        sb.append("$element ")
    }
    sb.append("\n")
}
