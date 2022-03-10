import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*


fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)

    val N = sc.nextInt()
    val X = sc.nextInt()
    var input = IntArray(N)

    for(i in 1..N){
        input[i-1] = sc.nextInt()
    }
    var left = 0
    var right = X-1
    var max = 0
    var cnt = 0
    var togle = true
    var temp = 0
    while(true){
        if(togle){
            for(i in left..right){
                temp+=input[i]
            }
            togle = false
        }else{
            temp+=input[right]
        }
        if(temp > max){
            cnt = 1
            max = temp
        }else if(temp == max){
            cnt++
        }
        temp-=input[left]
        left++
        right++
        if(right == N) break
    }
    if(max == 0){
        println("SAD")
    }else{
        println(max)
        println(cnt)
    }

    //var dp =  Array<IntArray>(b_len + 1, {IntArray(a_len + 1)})

}

