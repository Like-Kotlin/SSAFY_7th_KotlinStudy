package m2w7

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.collections.HashSet

fun main(){

    val br = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(br.readLine())

    val N = st.nextToken().toInt()
    val M = st.nextToken().toInt()
    var ans = 0
    val stringSet = HashSet<String>()

    repeat(N){
        stringSet.add(br.readLine())
    }

    repeat(M){
        val str = br.readLine()

        if(str in stringSet){
            ans++
        }
    }

    println(stringSet)

    println(ans)


}

