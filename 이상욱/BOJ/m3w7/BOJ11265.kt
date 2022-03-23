package m3w12

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main(){

    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())

    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()

    val map = Array(n){IntArray(n)}

    for(i in 0 until n){
        st = StringTokenizer(br.readLine())
        for(j in 0 until n){
            map[i][j] = st.nextToken().toInt()
        }
    }

    for(k in 0 until n){
        for(i in 0 until n){
            for(j in 0 until n){
                map[i][j] = map[i][j].coerceAtMost(map[i][k] + map[k][j])
            }
        }
    }

    repeat(m){
        st = StringTokenizer(br.readLine())
        val a = st.nextToken().toInt()
        val b = st.nextToken().toInt()
        val c = st.nextToken().toLong()

        if(map[a-1][b-1] <= c){
            println("Enjoy other party")
        }else{
            println("Stay here")
        }
    }

}