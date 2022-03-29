package m3w8

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

var V = 0
var E = 0
lateinit var parent : IntArray
lateinit var arr : Array<Node>

fun main(){

    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())

    V = st.nextToken().toInt()
    E = st.nextToken().toInt()

    arr = Array(E){Node(0,0,0)}
    parent = IntArray(V+1)

    for (i in 1..V){
        parent[i] = i
    }

    for(i in 0 until E) {
        st = StringTokenizer(br.readLine())
        val a = st.nextToken().toInt()
        val b = st.nextToken().toInt()
        val c = st.nextToken().toInt()

        arr[i] = Node(a,b,c)
    }

    println(kruskal())
}

fun kruskal() : Int{

    var res = 0
    var cnt = 0

    arr.sort()
    arr.forEach {
        if(union_(it.s,it.d)){
            res+= it.w
            cnt++
            if(cnt == V-1){
                return res
            }
        }
    }
    return res
}

fun union_(a : Int, b : Int) : Boolean{
    val aP = find(a)
    val bP = find(b)

    if(aP == bP) {
        return false
    }
    parent[aP] = parent[bP]
    return true
}

fun find(a : Int) : Int{
    if(a == parent[a]){
        return a
    }
    parent[a] = find(parent[a])
    return parent[a]
}

data class Node(val s : Int,val d : Int, val w : Int):Comparable<Node> {
    override fun compareTo(other: Node): Int {
        return w - other.w
    }
}