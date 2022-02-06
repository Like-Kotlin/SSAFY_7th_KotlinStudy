package level6

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(){

    val br = BufferedReader(InputStreamReader(System.`in`))

    var num = br.readLine().toInt()

    if( num < 100 ){
        println(num)
    }else{
        if(num == 1000){
            num = 999
        }

        val cnt = check(num)

        println(cnt)

    }

}

fun check(num : Int) : Int{

    var cnt = 0
    for (i in 100..num) {

        val str = i.toString()
        if (str[2] - str[1] == str[1] - str[0]) {
            cnt++
        }

    }

    return cnt+99

}