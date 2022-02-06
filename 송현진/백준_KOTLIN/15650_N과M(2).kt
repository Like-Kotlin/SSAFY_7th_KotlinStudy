import java.util.*
import java.io.*


var N = 0
var M = 0
fun main() {
    var br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine()," ")

    N = st.nextToken().toInt()
    M = st.nextToken().toInt()

    var arr = Array(M){0}
    backtracking(arr,1, 0)
}

fun backtracking(arr: Array<Int>, start: Int, dept: Int){
    if(dept == M){
        Print(arr)
        return
    }

    for(i in start..N){
            arr[dept] = i
            backtracking(arr, i+1, dept+1)

    }
}

fun Print(arr: Array<Int>){
    for(element in arr){
        print("$element ")
    }
    println()
}
