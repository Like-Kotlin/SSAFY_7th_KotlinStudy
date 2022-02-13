import java.util.*
import java.io.*

fun main() {
    var br = BufferedReader(InputStreamReader(System.`in`))
    var tc = br.readLine().toInt()

    for(i in 0 until tc){
        var N = br.readLine().toInt()
        println(fibonacci(N))
    }
}

fun fibonacci(N: Int): String{
    when (N) {
        0 -> return "1 0"
        1 -> return "0 1"
        2 -> return "1 1"
        else -> {
            var n1 = Pair(0, 1)
            var n2 = Pair(1, 1)
            
            var cnt = N - 2
            while (cnt-- >= 1) {
                var n3 = Pair(n1.first + n2.first, n1.second + n2.second)
                n1 = n2
                n2 = n3
            }
            return "${n2.first} ${n2.second}"
        }
    }
}
