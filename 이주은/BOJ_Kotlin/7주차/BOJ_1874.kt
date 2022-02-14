
import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.util.*

fun main()=with(BufferedReader(InputStreamReader(System.`in`))){

    val n = readLine().toInt()
    var stack = Stack<Int>()
    var idx = 0
    var sb = StringBuilder()

    for(i in 0 until n){
        var num = readLine().toInt()
        if (num > idx){
            for(j in idx + 1 .. num){
                stack.push(j)
                sb.append("+\n")
            }
            idx = num
        }

        else if(stack.peek() != num){
            println("NO")
            return
        }

        stack.pop()
        sb.append("-\n")
    }
    print(sb)
}