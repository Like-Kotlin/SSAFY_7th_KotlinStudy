package level9

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))

    val st = StringTokenizer(br.readLine())

    val num1 = st.nextToken().toInt()
    val num2 = st.nextToken().toInt()

    for (i in num1 .. num2) {
        checkPrime(i)

    }

}

private fun checkPrime(n: Int){

    if (n == 1) {
        return
    }

    if (n == 2) {
        println(n)
        return
    }

    for (i in 2..Math.sqrt(n.toDouble()).toInt()) {

        if (n % i == 0) {
            return
        }
    }

    println(n)
}