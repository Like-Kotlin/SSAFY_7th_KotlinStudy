package level10

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(){

    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()

    val num = IntArray(n+1)

    num[0] = 0

    if( n == 0 ){
        println(0)
        return
    }

    if(n == 1){
        println(1)
        return

    }

    num[1] = 1
    for( i in 2 until num.size){
        num[i] = num[i-1] + num[i-2]
    }
    println(num[n])

}