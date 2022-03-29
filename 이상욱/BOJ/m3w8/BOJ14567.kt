package m3w8

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main(){

    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())

    val N = st.nextToken().toInt()
    val M = st.nextToken().toInt()

    val map = Array(N+1){IntArray(N+1)}
    val memo = IntArray(N+1){-1}

    repeat(M){
        st = StringTokenizer(br.readLine())

        val a = st.nextToken().toInt()
        val b = st.nextToken().toInt()

        map[a][b] = 1

    }

    for(i in 1 .. N){
        var check = false
        for(j in 1 .. N){
            if(map[j][i] == 1){
                check = true
                break
            }
        }
        if(!check){
            memo[i] = 1

        }
    }

        for(i in 1 .. N){
            for(j in 1 .. N){
                if(map[i][j] == 1){
                    memo[j] = memo[j].coerceAtLeast(memo[i]+1)
                }
            }

        }

    val sb = StringBuilder()
    for(i in 1 .. N){
        sb.append("${memo[i]} ")
    }

    println(sb)
}