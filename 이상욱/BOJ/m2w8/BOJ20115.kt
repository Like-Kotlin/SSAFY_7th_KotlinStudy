package m2w8

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main(){

    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()
    val arr = DoubleArray(n)

    val st = StringTokenizer(br.readLine())

    for (i in 0 until n){
        arr[i] = st.nextToken().toDouble()
    }

    arr.sortDescending()
    var sum : Double = arr[0]

    for (i in 1 until n){
        sum = if(sum + arr[i]/2 > sum/2 + arr[i]){
            sum+arr[i]/2
        }else{
            sum/2 + arr[i]
        }
    }

    println(sum)
}


