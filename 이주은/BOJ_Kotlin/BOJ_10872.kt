import java.io.BufferedReader
import java.io.InputStreamReader

fun main()=with(BufferedReader(InputStreamReader(System.`in`))){
    val n = readLine().toInt()

    println(factorial(n))
}

fun factorial(num: Int):Int{
    if(num == 0)
        return 1

    return num * factorial(num - 1)
}