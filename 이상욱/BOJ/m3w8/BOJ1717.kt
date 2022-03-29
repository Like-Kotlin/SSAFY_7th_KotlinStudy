package m3w8

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.lang.StringBuilder
import java.util.*


lateinit var p : IntArray
fun main(){

    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    var st = StringTokenizer(br.readLine())

    val N = st.nextToken().toInt()
    val M = st.nextToken().toInt()

    p = IntArray(N+1)

    for(i in 1..N){
        p[i] = i
    }

    val sb = StringBuilder()

    for(i in 0 until M){
        st = StringTokenizer(br.readLine())

        val first = st.nextToken().toInt()

        val num1 = st.nextToken().toInt()
        val num2 = st.nextToken().toInt()

        if(first == 0){
            union(num1,num2)
        }else{
            if(findParent(num1) == findParent(num2)){
                sb.append("YES\n")
            }else{
                sb.append("NO\n")
            }
        }
    }

    bw.write(sb.toString())
    bw.flush()
    br.close()
    bw.close()

}

fun union(num1: Int, num2: Int) {
    val x = findParent(num1)
    val y = findParent(num2)

    if(x != y){
        if(x < y){
            p[y] = x
        }else{
            p[x] = y
        }
    }
}

fun findParent(x: Int): Int {

    if(x == p[x]){
        return x
    }
    p[x] = findParent(p[x])
    return p[x]
}
