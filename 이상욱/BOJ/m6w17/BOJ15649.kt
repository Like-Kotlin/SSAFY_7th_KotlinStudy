package m6w17

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

val sb = StringBuilder()
fun main(){

    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())

    val N = st.nextToken().toInt()
    val M = st.nextToken().toInt()

    val arr = IntArray(N)
    for(i in arr.indices){
        arr[i] = i + 1
    }

    val output = IntArray(N)
    val isUsed = BooleanArray(N)

    perm(arr,output,isUsed,0,N,M)

    println(sb)


}

fun perm(arr: IntArray, output: IntArray, isUsed: BooleanArray, depth: Int, n: Int, m: Int) {

    if(depth == m){
        for(i in 0 until m){
            sb.append("${output[i]} ")
        }
        sb.append("\n")
        return
    }

    for(i in 0 until n){
        if(!isUsed[i]){
            isUsed[i]= true
            output[depth] = arr[i]
            perm(arr, output, isUsed, depth+1, n, m)
            isUsed[i] = false
        }
    }

}
