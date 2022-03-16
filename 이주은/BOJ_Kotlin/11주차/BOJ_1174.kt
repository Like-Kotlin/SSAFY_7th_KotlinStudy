package `11주차`

import java.io.BufferedReader
import java.io.InputStreamReader

val list = ArrayList<Long>()
var num = arrayOf(9, 8, 7, 6, 5, 4, 3, 2, 1, 0)

fun main()=with(BufferedReader(InputStreamReader(System.`in`))){
    var n = readLine().toInt()
    if(n > 1023) {
        println(-1)
        return
    }
    findDesc(0, 0)
    list.sort()

    println(list.get(n - 1))

}

fun findDesc(sum: Long, idx: Int): Unit{
    if(!list.contains(sum))
        list.add(sum)

    if(idx >= 10)
        return

    findDesc(
        (sum * 10) + num[idx],
        idx + 1
    )
    findDesc(sum, idx + 1)
}