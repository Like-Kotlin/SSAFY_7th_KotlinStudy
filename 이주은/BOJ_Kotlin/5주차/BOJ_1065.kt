import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    var n = readLine().toInt()
    println(calc(n))
}

fun calc(n: Int): Int {
    var cnt = 0
    var num = n
    if(n < 100)
        return n

    else{
        cnt = 99
        if(n == 1000){
            num = 999
        }

        for(i in 100..num){
            var hun = i / 100
            var ten = (i / 10) % 10
            var one = i % 10

            if(hun - ten == ten - one)
                cnt++
        }
    }

    return cnt
}
