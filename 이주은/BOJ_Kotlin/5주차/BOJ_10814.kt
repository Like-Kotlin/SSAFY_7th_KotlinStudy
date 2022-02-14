import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main()=with(BufferedReader(InputStreamReader(System.`in`))){
    var n = readLine().toInt()

    val arr = MutableList<MutableList<String>>(n){ MutableList<String>(2, {"0"}) }

    for(i in 0 until n){
        var st = StringTokenizer(readLine())
        arr[i][0] = st.nextToken()
        arr[i][1] = st.nextToken()
    }

    arr.sortWith(kotlin.Comparator { o1, o2 ->
        o1[0].toInt() - o2[0].toInt()
    })

    for(i in 0 until n){
        println(arr[i][0] + " " + arr[i][1])
    }
}