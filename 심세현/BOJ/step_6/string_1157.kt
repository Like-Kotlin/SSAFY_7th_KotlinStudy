package step

import java.util.*

private val br = System.`in`.bufferedReader()

fun main() {
    var str = br.readLine().uppercase().toCharArray()
    var arr = Array<Int>(26, {0})

    for(i in 0 until str.size){
        arr[str[i].toInt() - 65]++
    }
    var max = -1
    var ch = '?'

    for(i in 0 until arr.size){
       if(max < arr[i]){
           max = arr[i]
           ch = (i+65).toChar()
       }
       else if(max == arr[i]) ch = '?'
    }
    println(ch)
}