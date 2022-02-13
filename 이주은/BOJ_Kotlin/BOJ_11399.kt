import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main()= with(BufferedReader(InputStreamReader(System.`in`))){
    var n = readLine().toInt()
    var arr = IntArray(n)
    var st = StringTokenizer(readLine())

    for(i in 0 until n){
        arr[i] = st.nextToken().toInt()
    }

    arr.sort()
    var sum = 0
    for(i in 0 until n){
        sum += (arr[i] * (n - i))
    }

    println(sum)
}