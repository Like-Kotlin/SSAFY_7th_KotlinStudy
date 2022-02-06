import java.io.*
import java.util.*

//큐 전역 선언을 위한 클래스
class globalQueue{
    //전역 선언 가능한 companion object
    companion object{
        var dq: Deque<Int> = LinkedList<Int>()
        //StringBuffer 사용안하면 시간 초과
        var sb = StringBuffer("")
    }
}

fun main(){
    var br = BufferedReader(InputStreamReader(System.`in`))
    var N = br.readLine().toInt()
    var dq = globalQueue.dq

    for(i in 1..N){
        var st = StringTokenizer(br.readLine()," ")
        var order = ""
        var num = 0

        if(st.countTokens() == 2){
            order = st.nextToken()
            num = st.nextToken().toInt()
            checkQueuePush(dq,num)
        }
        else {
            order = st.nextToken()
            checkQueue(dq, order)
        }
    }
    println(globalQueue.sb)
}

fun checkQueuePush(q: Deque<Int>, num: Int){
    q.add(num)
}

fun checkQueue(q: Deque<Int>, order: String): Serializable {
    var sb = globalQueue.sb
    return when{
        //order == "pop" 가능
        order.equals("pop") -> if(checkEmpty()==0) sb.append("${q.poll()}\n") else sb.append("-1\n")

        order.equals("size") -> sb.append("${q.size}\n")

        order.equals("front")-> if(checkEmpty()==0) sb.append("${q.first}\n") else sb.append("-1\n")

        order.equals("back") -> if(checkEmpty()==0) sb.append("${q.last}\n") else sb.append("-1\n")

        else -> if(checkEmpty()==0) sb.append("0\n") else sb.append("1\n")
    }
}
fun checkEmpty(): Int{
    return if(globalQueue.dq.size == 0) 1 else 0
}

