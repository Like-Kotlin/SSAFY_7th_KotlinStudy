package com.ssafy.lib.level2

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

//ěë ěęł
fun main(){

    val br = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(br.readLine())

    val h = st.nextToken().toInt()
    val m = st.nextToken().toInt()

    if (m - 45 < 0){
        if( h == 0 ){
            println("23 ${15+m}")
        }else{
            println("${h-1} ${15+m}")
        }
    }else{
        println("$h ${m-45}")
    }


}