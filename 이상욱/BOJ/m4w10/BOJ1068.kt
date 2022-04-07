package m4w10

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

lateinit var visit: BooleanArray
lateinit var tree: ArrayList<ArrayList<Int>>
var root = -1

fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))

    val N = br.readLine().toInt()

    visit = BooleanArray(N)

    tree = arrayListOf()
    repeat(N) {
        tree.add(arrayListOf())
    }
    val st = StringTokenizer(br.readLine())

    for (i in 0 until N) {
        val p = st.nextToken().toInt()
        if (p == -1) {
            root = i
        } else {
            tree[p].add(i)
        }
    }

    val removeNode = br.readLine().toInt()

    remove(removeNode)

    for(i in tree.indices){
        if(tree[i].contains(removeNode)){
            tree[i].remove(removeNode)
        }
    }

    var cnt = 0
    for (i in tree.indices) {
        if (!visit[i] && tree[i].isEmpty()) {
            cnt++
        }
    }

    println(cnt)
}

fun remove(removeNode: Int) {

    tree[removeNode].forEach {
        remove(it)
    }
    visit[removeNode] = true
    tree[removeNode].clear()
}