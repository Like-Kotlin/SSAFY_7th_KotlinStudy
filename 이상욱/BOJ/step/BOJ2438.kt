package level3

import java.io.BufferedReader
import java.io.InputStreamReader

// 별 찍기 - 1
fun main(){

    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()
    var sb = StringBuffer()

    for (i in 1 until n+1){
        for (j in 0 until i){
            sb.append("*")
        }
        sb.append("\n")
    }

    println(sb)

}