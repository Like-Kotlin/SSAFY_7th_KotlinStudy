package `14주차`

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

private lateinit var arr: Array<Double>

fun main()=with(BufferedReader(InputStreamReader(System.`in`))){

    val n = readLine().toInt()
    arr = Array<Double>(n){0.0}

    val st = readLine().toCharArray()
    for(i in 0 until n){
        arr[i] = readLine().toDouble()
    }

    val stack = Stack<Double>()
    for(i in 0 until st.size){
        val ch = st[i]
        if(ch >= 'A' && ch <='Z')
            stack.push(arr[ch-'A'])
        else{
            var tmp1 = stack.pop()
            var tmp2 = stack.pop()
            when (ch){
                '+' -> stack.push(tmp1 + tmp2)
                '-' -> stack.push(tmp2 - tmp1)
                '*' -> stack.push(tmp2 * tmp1)
                '/' -> stack.push(tmp2 / tmp1)
            }
        }
    }

    println(String.format("%.2f", stack.pop()))

}