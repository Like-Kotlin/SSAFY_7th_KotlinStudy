package m3w8

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.collections.ArrayList

var v = 0
var e = 0
lateinit var list : Array<ArrayList<Node_>>
fun main(){

    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())

    v = st.nextToken().toInt()
    e = st.nextToken().toInt()

    list = Array(v+1){ arrayListOf()}

    for(i in 0 until e){
        st = StringTokenizer(br.readLine())
        val a = st.nextToken().toInt()
        val b = st.nextToken().toInt()
        val c = st.nextToken().toInt()

        list[a].add(Node_(b,c))
        list[b].add(Node_(a,c))
    }

    println(prim())

}
fun prim() : Long{
    val visit = BooleanArray(v+1)
    val pq = PriorityQueue<Node_>()

    pq.offer(Node_(1,0))

    var res = 0L
    var cnt = 0

    while (pq.isNotEmpty()){

        val p = pq.poll()!!

        if(visit[p.s]){
            continue
        }

        res += p.w
        visit[p.s] = true
        cnt++
        if(cnt == v){
            return res
        }

        for(i in 0 until list[p.s].size){
            val np = list[p.s][i]
            if(visit[np.s]){
                continue
            }
            pq.offer(np)
        }
    }
    return res
}

data class Node_(val s : Int, val w : Int):Comparable<Node_> {
    override fun compareTo(other: Node_): Int {
        return w - other.w
    }
}


