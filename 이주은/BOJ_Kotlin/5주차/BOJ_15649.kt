import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main()=with(BufferedReader(InputStreamReader(System.`in`))){
    var st = StringTokenizer(readLine())
    var n = st.nextToken().toInt()
    var m = st.nextToken().toInt()

    var arr = IntArray(m)
    var check = BooleanArray(n + 1, {false})

    dfs(arr, check, n, m, 0)
}

fun dfs(arr: IntArray, check: BooleanArray, n: Int, m:Int, depth: Int): Unit{
    if(depth == m){
        for(i in 0 until m){
            print(arr[i].toString() + " ")
        }
        println()
        return
    }

    for(i in 1..n){
        if(!check[i]){
            check[i] = true
            arr[depth] = i
            dfs(arr, check, n, m, depth + 1)
            check[i] = false
        }
    }
}