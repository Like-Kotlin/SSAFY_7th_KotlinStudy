package `14주차`

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main()=with(BufferedReader(InputStreamReader(System.`in`))){

    val trees = TreeMap<String, Double>()
    var cnt = 0

    while(true){
        val tree: String? = readLine()

        if(tree == null || tree.length == 0)
            break

        trees[tree!!] = trees.getOrDefault(tree, 0.0) + 1
        cnt++
    }

    for((key, value) in trees){
        println("$key ${String.format("%.4f", value / cnt * 100)}")
    }

}

