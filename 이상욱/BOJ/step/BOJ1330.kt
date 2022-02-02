package com.ssafy.lib.level2

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

//두 수 비교하기
fun main(){

    val br = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(br.readLine())

    val a = st.nextToken().toInt()
    val b = st.nextToken().toInt()

    if(a < b){
        println("<")
    }else if (a>b){
        println(">")
    }else if ( a==b ){
        println("==")
    }
}