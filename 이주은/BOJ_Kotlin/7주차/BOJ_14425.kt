import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.collections.HashMap

fun main()= with(BufferedReader(InputStreamReader(System.`in`))){
    var st = StringTokenizer(readLine())

    var n = st.nextToken().toInt()
    var m = st.nextToken().toInt()
    var cnt = 0

    var map = HashMap<String, Int>()

    for(i in 0 until n){
        var s = readLine()
        map.put(s, 1)
    }

    for(i in 0 until m){
        var s = readLine()
        if(map.containsKey(s))
            cnt++
    }

    print(cnt)
}