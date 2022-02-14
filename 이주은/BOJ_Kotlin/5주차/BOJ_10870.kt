import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    var n = readLine().toInt()

    println(fib(n))
}

fun fib(num: Int): Int{
    if(num == 0 || num == 1)
        return num

    return fib(num - 1) + fib(num - 2)
}