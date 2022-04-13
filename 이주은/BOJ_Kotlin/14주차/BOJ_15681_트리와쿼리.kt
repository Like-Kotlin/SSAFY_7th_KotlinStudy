package `14주차`

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer


private lateinit var parent: Array<Int>
private lateinit var size: Array<Int>
private val list = mutableListOf<MutableList<Int>>()
private val tree = mutableListOf<MutableList<Int>>()

fun main()=with(BufferedReader(InputStreamReader(System.`in`))){
    var st = StringTokenizer(readLine())
    val n = st.nextToken().toInt()
    val r = st.nextToken().toInt()
    val q = st.nextToken().toInt()

    parent = Array<Int>(n + 1){0}
    size = Array<Int>(n + 1){0}

    for(i in 0 .. n){
        list.add(mutableListOf())
        tree.add(mutableListOf())
    }

    for(i in 1 until n){
        st = StringTokenizer(readLine())
        val u = st.nextToken().toInt()
        val v = st.nextToken().toInt()

        list.get(u).add(v)
        list.get(v).add(u)
    }

    makeTree(r, -1)
    countSubtree(r)
    for(i in 0 until q){
        val target = readLine().toInt()
        println(size[target])
    }


}

fun makeTree(now: Int, p: Int): Unit{
    for(node in list.get(now)){
        if(node != p){
            tree.get(now).add(node)
            parent[node] = now
            makeTree(node, now)
        }
    }
}

fun countSubtree(root: Int){
    size[root] = 1

    for(node in tree[root]){
        countSubtree(node)
        size[root] += size[node]
    }
}