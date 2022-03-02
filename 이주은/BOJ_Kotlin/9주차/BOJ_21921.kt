package `9주차`

import java.util.*

fun main()=with(Scanner(System.`in`)){
    var n = nextInt()
    var x = nextInt()

    val arr = IntArray(n)
    for (i in 0 until n){
        arr[i] = nextInt()
    }

    var max = 0
    var sum = 0
    var end = 0
    var len = 0
    var cnt = 0

    for(start in 0 until n){
        while(end < n && len != x){
            sum += arr[end]
            end++
            len++
        }

        if(len == x){
            if(max < sum){
                cnt = 1
                max = sum
            }
            else if(max == sum){
                cnt++
            }
        }

        sum -= arr[start]
        len--
    }
    if(max != 0){
        println(max)
        println(cnt)
    }
    else{
        println("SAD")
    }

}