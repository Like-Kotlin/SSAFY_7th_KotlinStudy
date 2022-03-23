package m2w7

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.util.*

fun main(){

    val br = BufferedReader(InputStreamReader(System.`in`))

    val N = br.readLine().toInt()

    val inputArr = IntArray(N)

    repeat(N){
        inputArr[it] = br.readLine().toInt()
    }

    var num = 1
    var idx = 0
    val stk = Stack<Int>()

    val sb = StringBuilder()

    while (idx < N){

        if(num > N){
            println("NO")
            return
        }

        stk.push(num)
        sb.append("+\n")

            while(stk.isNotEmpty() && stk.peek() == inputArr[idx]){

                stk.pop()
                sb.append("-\n")
                idx++

            }

        num++

    }

    println(sb)


}