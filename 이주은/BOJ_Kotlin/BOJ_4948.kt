import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.sqrt

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    while(true){
        var n = readLine().toInt()
        if(n == 0)
            break

        var cnt = 0
        for(i in n + 1..2 * n){
            if(findPrimary(i))
                cnt++
        }
        println(cnt)
    }
}

fun findPrimary(num: Int): Boolean{
    if(num == 1)
        return false

    if(num == 2)
        return true

    for(i in 2..sqrt(num.toDouble()).toInt()){
        if(num % i == 0)
            return false
    }

    return true

}
