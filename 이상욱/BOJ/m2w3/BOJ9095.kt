package m2w8

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = Integer.parseInt(br.readLine())
    val arr = IntArray(11)

    arr[1] = 1
    arr[2] = 2
    arr[3]=  4

    for (i in 4 until arr.size){
        arr[i] = arr[i-1] + arr[i-2] + arr[i-3]
    }


    for (i in 0 until n){
        val num = Integer.parseInt(br.readLine())

        println(arr[num])

    }

}