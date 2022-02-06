import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    var st = StringTokenizer(readLine())
    var n = st.nextToken().toInt()
    var k = st.nextToken().toInt()
    var arr = IntArray(n)
    var cnt = 0

    for(i in 0 until n){
        arr[i] = readLine().toInt()
    }

    for(i in n - 1 downTo 0){
        if(arr[i] <= k){
            cnt += (k / arr[i])
            k %= arr[i]
        }
    }

    println(cnt)
}