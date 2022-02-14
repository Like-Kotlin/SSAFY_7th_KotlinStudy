import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val n = readLine().toInt()
    var num = n
    var cnt = 0

    while(true){
        num = ((num % 10) * 10) + (((num / 10) + (num % 10)) % 10)
        cnt++

        if(n == num)
            break;
    }

    println(cnt)

}