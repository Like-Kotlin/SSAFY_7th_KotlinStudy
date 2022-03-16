package `11주차`

import java.io.BufferedReader
import java.io.InputStreamReader

fun main()=with(BufferedReader(InputStreamReader(System.`in`))){
    val arr = readLine().split(" ")
    val n = arr[0].toInt()
    val r = arr[1].toInt()
    val c = arr[2].toInt()

    var size = Math.pow(2.0, n.toDouble()).toInt()

    var cnt = 0
    var x = 0
    var y = 0

    while(size > 0){
        size /= 2

        if(r < x + size && c < y + size){
            continue
        }

        if(r < x + size){
            cnt += size * size
            y += size
        }

        else if(c < y + size){
            cnt += size * size * 2
            x += size
        }
        else{
            cnt += size * size * 3
            y += size
            x += size
        }

        if(size == 1)
            break
    }
    println(cnt)
}