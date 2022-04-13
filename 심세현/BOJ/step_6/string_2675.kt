package step

import java.util.*

private val br = System.`in`.bufferedReader()

fun main() {
    var T = br.readLine().toInt()

    for(i in 0 until T){
        var sb = StringBuilder()
        var st = StringTokenizer(br.readLine())
        var time = st.nextToken().toInt()
        var str = st.nextToken().toCharArray()

        for(j in 0 until str.size){
            for(k in 0 until time){
                sb.append(str[j])
            }
        }
        println(sb)
    }

}