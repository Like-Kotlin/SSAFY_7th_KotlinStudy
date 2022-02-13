import java.util.*
import java.io.*

fun main() {
    var br = BufferedReader(InputStreamReader(System.`in`))
    var N = br.readLine().toInt()
    var result = findResult(N)
    println(result)
}

fun findResult(N: Int): Int{
    when (N) {
        1 -> return 1
        2 -> return 2
        else -> {
            var n1 = 1
            var n2 = 2
            var cnt = N-2
            
            while(cnt-->= 1){
			//15746으로 여기서 나누어줘야 했는데 return에서 나눠버린 실수가 있었음
                var n3 = (n1 + n2) % 15746
                n1 = n2
                n2 = n3
            }
            return n2
        }
    }
}
