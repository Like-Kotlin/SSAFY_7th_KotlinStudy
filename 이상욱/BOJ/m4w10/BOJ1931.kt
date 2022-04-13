package m4w10

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main(){

    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()

    val map = Array(n){IntArray(2)}
    var st : StringTokenizer

    for(i in 0 until n){
        st = StringTokenizer(br.readLine())
        map[i][0] = st.nextToken().toInt()
        map[i][1] = st.nextToken().toInt()
    }

    map.sortWith(compareBy({it[1]},{it[0]}))

    var cnt = 0
    var end = 0

    map.forEach {
        if(end <= it[0]){

            end = it[1]
            cnt++
        }
    }

    println(cnt)

}