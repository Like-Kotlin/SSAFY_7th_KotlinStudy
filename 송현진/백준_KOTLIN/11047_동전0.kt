
import java.util.*
import java.io.*

fun main() {
    var br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine()," ")

    var N = st.nextToken().toInt()
    var total = st.nextToken().toInt()

    var arr = Array<Int>(N){0}

    for(i in 0 until N){
        arr[i] = br.readLine().toInt()
    }
    
    var cnt = 0

    for(i in N-1 downTo 0){
        if(total >= arr[i]){
            cnt += total / arr[i]
            total %= arr[i]
        }
    }
    println(cnt)
}