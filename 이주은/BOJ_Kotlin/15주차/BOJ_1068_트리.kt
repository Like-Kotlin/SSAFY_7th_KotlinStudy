package `15주차`

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

private lateinit var arr: Array<Int>
private lateinit var visited: Array<Boolean>
private var n = 0
private var count = 0

fun main()=with(BufferedReader(InputStreamReader(System.`in`))){
    n = readLine().toInt()
    arr = Array(n, {i -> 0})
    visited = Array(n, {false})

    var st = StringTokenizer(readLine())
    var root = 0

    for(i in 0 until n){
        arr[i] = st.nextToken().toInt()
        if(arr[i] == -1)
            root = i
    }

    delete(readLine().toInt())
    dfs(root)

    println(count)
}

fun delete(node: Int){
    arr[node] = n + 1
    for(i in 0 until n){
        if(arr[i] == node)
            delete(i)
    }
}

fun dfs(node: Int){
    var isLeaf = true
    visited[node] = true

    if(arr[node] != n + 1){
        for(i in 0 until n){
            if(arr[i] == node && !visited[i]) {
                dfs(i)
                isLeaf = false
            }
        }
        if(isLeaf)
            count++
    }
}