package `8주차`

import java.io.BufferedReader
import java.io.InputStreamReader

fun main()=with(BufferedReader(InputStreamReader(System.`in`))){
    val n = readLine().toInt();
    val arr = IntArray(12)

    arr[1] = 1
    arr[2] = 2
    arr[3] = 4

    for(i in 4 until 12){
        arr[i] = arr[i - 1] + arr[i - 2] + arr[i - 3]
    }

    for (i in 0 until n){
        val idx = readLine().toInt()

        println(arr[idx])
    }
}