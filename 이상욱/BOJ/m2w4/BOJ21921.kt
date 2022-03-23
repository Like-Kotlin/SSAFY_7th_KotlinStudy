package m2w9

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())

    val n = st.nextToken().toInt()
    val x = st.nextToken().toInt()

    val arr = IntArray(n)

    st = StringTokenizer(br.readLine())

    for(i in 0 until n){
        arr[i] = st.nextToken().toInt()
    }

    var sum = 0L

    for(i in 0 until x){
        sum+=arr[i]
    }
    var cnt = 1
    var max = sum
    for(i in x until n){
        sum+=arr[i]
        sum-=arr[i-x]
        if(sum > max){
            max = sum
            cnt = 1
        }else if(sum == max){
            cnt++
        }
    }

    if(max == 0L){
        println("SAD")
    }else {
        println(max)
        println(cnt)
    }

}