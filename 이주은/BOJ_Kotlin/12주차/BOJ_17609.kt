package `12주차`

import java.io.BufferedReader
import java.io.InputStreamReader

fun main()= with(BufferedReader(InputStreamReader(System.`in`))){
    var n = readLine().toInt()
    for(i in 0 until n){
        var st = readLine().toCharArray()
        var left = 0
        var right = st.size - 1

        if(checkP(left, right, st)){
            println(0)
            continue
        }

        if(!checkPP(left, right, st)){
            println(1)
        } else
            println(2)

    }
}

fun checkP(left: Int, right: Int, st: CharArray): Boolean{
    var l = left
    var r = right
    while(l <= r){
        if(st[l] != st[r])
            return false
        l++
        r--
    }
    return true
}

fun checkPP(left: Int, right: Int, st: CharArray): Boolean{
    var l = left
    var r = right

    while(l <= r){
        if(st[l] != st[r]){
            var a = checkP(l + 1, r, st)
            var b = checkP(l, r - 1, st)

            return (!a && !b)
        }
        l++
        r--
    }
    return true
}