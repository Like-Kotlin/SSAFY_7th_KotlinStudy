import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.collections.ArrayList

var V = 0
var E = 0
lateinit var arr: Array<ArrayList<Node>>
data class Node(var to:Int, var weight:Int): Comparable<Node>{

    override fun compareTo(other: Node): Int {
        return Integer.compare(this.weight, other.weight)
    }
}
fun main() {
    var br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())

    V = st.nextToken().toInt()
    E = st.nextToken().toInt()

    arr = Array(V+1){ arrayListOf() }

    for(i in 0 until E){
        st = StringTokenizer(br.readLine())
        var start = st.nextToken().toInt()
        var end = st.nextToken().toInt()
        var value = st.nextToken().toInt()

        arr[start].add(Node(end, value))
        arr[end].add(Node(start,value))
    }
    println(prim())
}

fun prim():Int{
    var visited = Array(V+1){false}
    var pq = PriorityQueue<Node>()

    pq.add(Node(1,0))

    var ans = 0
    var cnt = 0
    while(!pq.isEmpty()){
        var curNode = pq.poll()

        if(visited[curNode.to]) continue

        ans += curNode.weight
        visited[curNode.to] = true
        cnt++
        if(cnt == V) return ans

        for(i in 0 until arr[curNode.to].size){
            var next = arr[curNode.to][i]
            if(visited[next.to]) continue

            pq.add(next)
        }
    }
    return ans
}