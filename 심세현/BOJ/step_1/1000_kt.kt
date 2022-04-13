package step

import java.util.*


private val br = System.`in`.bufferedReader()

fun main() {
    var st = StringTokenizer(br.readLine())
    var A : Int = Integer.parseInt(st.nextToken())
    var B : Int = Integer.parseInt(st.nextToken())

    print("${A+B}")
}