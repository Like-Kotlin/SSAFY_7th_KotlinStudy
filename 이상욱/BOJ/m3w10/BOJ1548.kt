package m3w10

import java.io.*
import java.util.*

fun main(){

    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()
    val arr = IntArray(n)

    val st = StringTokenizer(br.readLine())
    for(i in 0 until n){
        arr[i] = st.nextToken().toInt()
    }

    if(arr.size <= 2 ){
        println(arr.size)
        return
    }

    arr.sort()

    var max = -1

    for(i in 0 until n-2){
        for(j in n-1 downTo i+2){
            if(arr[i] + arr[i+1] > arr[j]){
                max = Math.max(max, j-i+1)
            }
        }
    }

    if(max == -1){
        max = 2
    }
    println(max)
}