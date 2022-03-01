import java.util.*
import java.io.*
import kotlin.math.max

fun main(){
    var br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine()," ")

    var N = st.nextToken().toInt()
    var X = st.nextToken().toInt()

    var arr = Array(N){0}
    st = StringTokenizer(br.readLine()," ")
    for(i in 0 until N){
        arr[i] = st.nextToken().toInt()
    }

    calculate(N,X,arr)
}
fun calculate(N: Int, X:Int, arr:Array<Int>){
    var max = 0
    var cnt = 1
    for(i in 0 until X){
        max += arr[i]
    }
    var cur = max
    for(i in X until N){
        //현재값은 더하고, 현재-X값은 빼기
        cur += arr[i] - arr[i-X]
        if(cur == max){
            cnt++
        }else if(max < cur){
            cnt = 1
        }
        max = max(cur,max)
    }

    printResult(max,cnt)
}

fun printResult(max: Int, cnt: Int){
    if(max == 0){
        println("SAD")
    }else{
        println(max)
        println(cnt)
    }
}
