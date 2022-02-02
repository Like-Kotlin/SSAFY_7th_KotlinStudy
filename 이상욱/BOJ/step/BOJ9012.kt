package level17

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main(){

    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()

    repeat(n){

        val vps = br.readLine()
        val answer = check(vps)
        println(answer)

    }

}

fun check(vps : String) : String{

    val stk = Stack<Char>()

    for(i in vps.indices){

        if(stk.isEmpty()){
            stk.add(vps[i])
        }else{
            val c = stk.peek()

            if(c == '(' && vps[i] == ')'){
                stk.pop()
            }else{
                stk.add(vps[i])
            }
        }

    }

    return if(stk.isEmpty()){
        "YES"
    }else{
        "NO"
    }

}