package com.ssafy.lib.level1

import java.io.*
import java.util.*


//A+B
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(br.readLine())
    var a = st.nextToken().toInt()
    var b = st.nextToken().toInt()
    println(a+b)
}