import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.collections.HashMap

fun main() {
    var br = BufferedReader(InputStreamReader(System.`in`))

    var totalCnt = 0
    //자동 정렬 + MAP기능 포함
    var hm = TreeMap<String,Int>()

    while(true){
        var st = br.readLine() ?: break

        totalCnt++
        hm.put(st, hm.getOrDefault(st, 0)+1)
    }


    var sb = StringBuilder()
    hm.forEach{
        var value = hm.getValue(it.key)
        var percent = value * 100.0 / totalCnt
        sb.append("${it.key} ${String.format("%.4f", percent)} \n")
    }

    println(sb)
}