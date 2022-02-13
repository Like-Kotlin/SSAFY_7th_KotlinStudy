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
    var visit = Array(N){false}
    backtracking(arr, visit, 0)
}

fun backtracking(arr: Array<Int>, visit: Array<Boolean>, dept: Int){
    if(dept == M){
        Print(arr)
        return
    }

    for(i in 0 until N){
        if(!visit[i]){
            visit[i] = true
            arr[dept] = i+1
            backtracking(arr,visit,dept+1)
            visit[i] = false
        }
    }
}

fun Print(arr: Array<Int>){
    for(element in arr){
        print("$element ")
    }
    println()
}
