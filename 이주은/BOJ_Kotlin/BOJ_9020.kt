import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.sqrt

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    for(i in 1..n){
        var target = readLine().toInt()
        var res1 = 0
        var res2 = 0

        for(j in 2..target/2){
            if(j != 2 && j % 2 == 0)
                continue
            var check1 = findPrime(j)
            var check2 = findPrime(target-j)

            if(check1 && check2){
                res1 = j
                res2 = target - j
            }
        }

        println(res1.toString() + " " + res2.toString())
    }
}

fun findPrime(num: Int): Boolean{
    if(num == 1)
        return false

    for(i in 2..sqrt(num.toDouble()).toInt())
        if(num % i == 0)
            return false

    return true
}