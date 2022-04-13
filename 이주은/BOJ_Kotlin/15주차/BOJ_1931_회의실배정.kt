package `15주차`

import java.io.BufferedReader
import java.io.InputStreamReader

fun main()=with(BufferedReader(InputStreamReader(System.`in`))){
    val n = readLine().toInt()
    val arr = Array<Pair<Int, Int>>(n, {Pair(0, 0)})

    for(i in 0 until n){
        val(a, b) = readLine().split(' ')
        arr[i] = Pair(a.toInt(), b.toInt())
    }

    var arr_sorted = arr.sortedWith(compareBy ({ it.second }, {it.first}))


    var cnt = 0
    var prev = 0

    for(i in 0 until n){
        if(prev <= arr_sorted[i].first){
            prev = arr_sorted[i].second
            cnt++
        }
    }

    println(cnt)
}