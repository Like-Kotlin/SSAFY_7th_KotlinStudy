import java.util.*
import kotlin.collections.HashSet

fun gcd(a:Long, b:Long):Long{
    if(b == 0L) return a;
    return gcd(b, a % b)
}

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)

    val T = sc.nextInt()

    for(i in 1..T){
        var inputs = mutableListOf<Long>()
        val N = sc.nextInt()
        var result:Long = 0L
        for(j in 1 .. N){
            val temp = sc.nextLong()
            inputs.add(temp)
        }
        for(j in 0..N-2){
            for(k in j + 1 .. N-1){
                result+=gcd(inputs[j],inputs[k])
            }
        }
        println(result)
    }
}

