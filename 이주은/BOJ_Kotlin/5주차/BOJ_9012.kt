import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    var n = readLine().toInt()
    for(i in 0 until n){
        var stack = Stack<Char>()
        var s = readLine().toCharArray()
        var flag = true

        for(j in 0 until s.size){
            if(stack.isEmpty() && s[j] == ')'){
                flag = false
                break
            }

            if(s[j] == ')') {
                stack.pop()
            }
            else
                stack.push('(')
        }

        if(stack.isEmpty() && flag)
            println("YES")
        else
            println("NO")

    }
}