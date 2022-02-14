import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.collections.ArrayList

fun main()= with(BufferedReader(InputStreamReader(System.`in`))){
    val n = readLine().toInt()
    val tree = Array(n + 1, {ArrayList<Int>()})
    val num = Array(n + 1, {0})

    for(i in 0 until n - 1){
        var st = StringTokenizer(readLine())
        var start = st.nextToken().toInt()
        var end = st.nextToken().toInt()

        tree[start].add(end)
        tree[end].add(start)
    }

    var queue = LinkedList<Int>();
    queue.add(1)
    num[1] = 1

    while(!queue.isEmpty()){
        var tmp = queue.poll()

        for(i in 0 until tree[tmp].size){
            if(num[tree[tmp].get(i)] == 0) {
                num[tree[tmp].get(i)] = tmp
                queue.add(tree[tmp].get(i))
            }
        }
    }

    for(i in 2 .. n){
        println(num[i])
    }

}