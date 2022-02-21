package `8주차`

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main()=with(BufferedReader(InputStreamReader(System.`in`))){
    val n = readLine().toInt()
    val arr = DoubleArray(n)
    var max = -1.0
    var sum = 0.0

    var st = StringTokenizer(readLine())
    for(i in 0 until n){
        arr[i] = st.nextToken().toDouble()
        if(max < arr[i])
            max = arr[i]
    }

    for(i in 0 until n){
        if(max != arr[i])
            sum += arr[i] / 2
        println(sum)
    }
    sum += max

    println(sum)

}