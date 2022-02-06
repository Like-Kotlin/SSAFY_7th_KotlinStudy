import java.util.*
import java.io.*

class ob{
    companion object{
        var stack: Stack<Int> = Stack()
        var sb = StringBuffer("")
    }
}

fun main(){
    var br = BufferedReader(InputStreamReader(System.`in`))
    var N = br.readLine().toInt()

    var st = ob.stack

    for(i in 1..N){
        var st = StringTokenizer(br.readLine(), " ")
        var order = ""
        var num = 0
        if(st.countTokens() == 2){
            order = st.nextToken()
            num = st.nextToken().toInt()
            checkPush(num)
        }
        else{
            order = st.nextToken()
            ob.sb.append("${checkStack(order)}\n")
        }
    }
    println(ob.sb)
}

fun checkPush(num: Int){
    ob.stack.push(num)
}
fun checkStack(order: String): Int{
    var st = ob.stack
    return when{
        order == "pop" -> if(emptyStack()==0) st.pop() else -1

        order == "size" -> st.size

        order == "top" -> if(emptyStack()==0) st.peek() else -1

        else -> if(emptyStack()==1) 1 else 0
    }
}

fun emptyStack(): Int{
    return if(ob.stack.size == 0) 1 else 0
}

