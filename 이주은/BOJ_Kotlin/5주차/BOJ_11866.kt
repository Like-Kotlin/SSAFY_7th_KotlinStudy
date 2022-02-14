
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main()=with(BufferedReader(InputStreamReader(System.`in`))){
    var st = StringTokenizer(readLine())
    var n = st.nextToken().toInt()
    var k = st.nextToken().toInt()
    var q = LinkedList<Int>()

    for(i in 1..n){
        q.add(i)
    }

    print("<")
    while(!q.isEmpty()){
        for(i in 0 until k - 1){
            var num = q.poll()
            q.add(num)
        }
        if(q.size != 1){
            print(q.poll().toString() + ", ")
        } else
            print(q.poll().toString() + ">")
    }

}