package level17

import java.io.BufferedReader
import java.io.InputStreamReader

var br = BufferedReader(InputStreamReader(System.`in`))

fun main(){

    val input = br.readLine().split(" ")
    val n = input[0].toInt()
    val r = input[1].toInt()

    val answer = factorial(n) / ( factorial(r)*factorial(n-r) )

    println(answer)
}

fun factorial(x: Int): Int {
    var r = 1
    for (i in x downTo 1) r *= i
    return r
}