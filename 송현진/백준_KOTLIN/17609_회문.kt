import java.io.*
import java.util.*
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

lateinit var arr:String
fun main(){
    var br = BufferedReader(InputStreamReader(System.`in`))
    var N = br.readLine().toInt()

    var sb = StringBuilder()
    for(i in 1..N){
        arr = br.readLine()

        var result = findResult()
        sb.append("$result\n")
    }
    println(sb)
}

fun findResult():Int{
    var left = 0
    var right = arr.length-1

    if(check(left, right)){
        return 0
    }
    return if(checkLR(left,right)){
        1
    }else{
        2
    }
}

fun check(left:Int, right:Int):Boolean {
    var L = left
    var R = right
    while(L <= R){
        //다르면
        if(arr[L] != arr[R]){
            return false
        }
        L++
        R--
    }
    return true
}

fun checkLR(left:Int, right:Int):Boolean{
    var L = left
    var R = right
    while(L <= R){
        if(arr[L] != arr[R]){
            var a = check(L+1, R)
            var b = check(L,R-1)

            //맞거나 아니거나 둘 중 하나일 때 리턴해주어야한다.
            //리턴안해주면 탐색하다가 시간 다 지나서 시간초과 발생
//            return !(!a && !b)
            return a || b
        }
        L++
        R--
    }
    return true
}