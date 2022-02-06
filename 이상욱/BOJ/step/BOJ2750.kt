package level12

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(){

    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()

    val arr = IntArray(n)

    for(i in 0 until n){
        arr[i] = br.readLine().toInt()
    }

    arr.sort()

    for(i in arr.indices){
        println(arr[i])
    }

}