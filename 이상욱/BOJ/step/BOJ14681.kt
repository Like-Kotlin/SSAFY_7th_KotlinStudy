package com.ssafy.lib.level2

import java.io.BufferedReader
import java.io.InputStreamReader


//사분면 고르기
fun main(){

    val br = BufferedReader(InputStreamReader(System.`in`))
    val x = br.readLine().toInt()
    val y = br.readLine().toInt()

    if(x >0 && y >0){
        println("1")
    }else if (x <0 && y>0 ){
        println("2")

    }else if (x <0 && y<0 ){
        println("3")
    }else if (x >0 && y<0 ){
        println("4")
    }
}