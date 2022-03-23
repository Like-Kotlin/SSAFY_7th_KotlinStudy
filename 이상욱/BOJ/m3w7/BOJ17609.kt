package m3w12

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(){

    val br = BufferedReader(InputStreamReader(System.`in`))

    val T = br.readLine().toInt()

    repeat(T){
        var ans = 2
        val string = br.readLine()
        if(palinDrome(string)){
            ans = 0
        }else if(palinDrome2(string)){
            ans = 1
        }
        println(ans)

    }
}


fun palinDrome(string: String) : Boolean {
    var start = 0
    var end = string.length-1

    while(start <= end){
        if(string[start] != string[end]){
            return false
        }
        start++
        end--
    }
    return true
}

fun palinDrome2(string: String): Boolean {
    var start = 0
    var end = string.length-1

    while(start <= end){
        if(string[start] != string[end]){

            val res = palinDrome(string.substring(start+1,end+1))
            val res1 = palinDrome(string.substring(start,end))

            return res || res1

        }
        start++
        end--
    }
    return true
}