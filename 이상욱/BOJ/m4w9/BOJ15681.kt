package m4w9

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.collections.ArrayList

lateinit var list : Array<ArrayList<Int>>
lateinit var tree : Array<ArrayList<Int>>
lateinit var p : IntArray
lateinit var size : IntArray
fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    var st = StringTokenizer(br.readLine())

    val n = st.nextToken().toInt()
    val r = st.nextToken().toInt()
    var q = st.nextToken().toInt()

    p = IntArray(n+1)
    size = IntArray(n+1)
    list = Array(n+1){ arrayListOf()}
    tree = Array(n+1){ arrayListOf()}

    for(i in 1 until n){
        st = StringTokenizer(br.readLine())

        val u = st.nextToken().toInt()
        val v = st.nextToken().toInt()

        list[u].add(v)
        list[v].add(u)
    }

    makeTree(r,-1)
    countSubTreeNodes(r)
    val sb = StringBuilder()

    while(q > 0){
        val query = br.readLine().toInt()

        sb.append(size[query]).append("\n")
        q--
    }

    bw.write(sb.toString())
    bw.flush()
    br.close()
    bw.close()

}

fun makeTree(currentNode : Int, parent : Int){
    list[currentNode].forEach {
        if( it != parent){
            tree[currentNode].add(it)
            p[it] = currentNode
            makeTree(it,currentNode)

        }
    }
}

fun countSubTreeNodes(currentNode: Int){
    size[currentNode] = 1

    tree[currentNode].forEach {
        countSubTreeNodes(it)
        size[currentNode] += size[it]
    }
}

