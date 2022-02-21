package `8주차`

import java.io.BufferedReader
import java.io.InputStreamReader

fun main()=with(BufferedReader(InputStreamReader(System.`in`))){
    val n = readLine().toInt()

    for(i in 0 until n){
        var sum = 0L

        var str = readLine().split(" ")

        for(j in 1 until str[0].toInt()){
            for(k in j + 1 until str[0].toInt() + 1){
                sum += gcd(str[j].toInt(), str[k].toInt())
            }
        }

        println(sum)
    }


}

fun gcd(a: Int, b: Int): Int{
    var a_ = a
    var b_ = b
    var n = 0

    if(a > b){
        a_ = b
        b_ = a
    }

    while(b_ != 0){
        n = b_
        b_ = a_ % b_
        a_ = n
    }

    return a_
}