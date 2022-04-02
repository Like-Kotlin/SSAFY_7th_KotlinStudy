package m4w9

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.lang.StringBuilder

fun main(){

    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val map = hashMapOf<String,Int>()


    var tot = 0
    while (true){
        val tree = br.readLine()?:break

        tot++
        map[tree] = map.getOrDefault(tree,0) + 1
    }

    val sb = StringBuilder()

    val sortedMap = map.toSortedMap()

    for( t in sortedMap.keys ){
        val tName = t
        val cnt = map[t]

        if (cnt != null) {
            sb.append("$tName ${String.format("%.4f",cnt*100 / tot.toDouble())}\n")
        }
    }
    bw.write(sb.toString())
    bw.flush()
    br.close()
    bw.close()

}