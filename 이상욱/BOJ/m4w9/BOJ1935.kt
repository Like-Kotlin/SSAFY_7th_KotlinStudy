package m4w9

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()

    val question = br.readLine()
    val list = arrayListOf<String>()
    repeat(n){
        val num = br.readLine()
        list.add(num)
    }

    val queue = LinkedList<String>()

    for(q in question){
        if(q != '+' && q != '-' && q != '*' && q != '/'){
            val num = list[q -'A']
            queue.offer(num)

        }else{
            queue.offer(q.toString())
        }
    }

    val stk = Stack<String>()

    while (queue.isNotEmpty()){

        val poll = queue.poll()

        if(poll != "+" && poll != "-" && poll != "*" && poll != "/"){
            stk.push(poll)
        }else{

            val num1 = stk.pop().toDouble()
            val num2 = stk.pop().toDouble()

            val res = calc(num1,num2,poll)

            stk.push(res.toString())

        }

    }

    val answer = stk.pop().toDouble()
    println(String.format("%.2f",answer))

}

fun calc(num1: Double, num2: Double, poll: String): Double {

    when(poll){
        "+" -> return num2 + num1
        "-" -> return num2 - num1
        "*" -> return num2 * num1
        "/" -> return num2 / num1

    }
    return 0.0
}
