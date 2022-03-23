package `12주차`

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main()=with(BufferedReader(InputStreamReader(System.`in`))){
    var st = StringTokenizer(readLine())
    var n = st.nextToken().toInt()
    var m = st.nextToken().toInt()

    val map = Array<Array<Int>>(n + 1, { Array<Int>(n + 1, { 0 }) })
    for(i in 1 .. n){
        st = StringTokenizer(readLine())
        for(j in 1 .. n){
            var num = st.nextToken().toInt()
            map[i][j] = map[i - 1][j] + map[i][j - 1] - map[i - 1][j - 1] + num
        }
    }

    for(i in 1 .. m){
        st = StringTokenizer(readLine())
        var x1 = st.nextToken().toInt()
        var y1 = st.nextToken().toInt()
        var x2 = st.nextToken().toInt()
        var y2 = st.nextToken().toInt()

        println(map[x2][y2] - map[x1 - 1][y2] - map[x2][y1 - 1] + map[x1 - 1][y1 - 1])
    }



}