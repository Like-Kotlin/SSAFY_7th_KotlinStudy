import java.util.*
import kotlin.collections.HashSet

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)

    var N = sc.next().toInt()
    var M = sc.next().toInt()
    var s = HashSet<String>();

    for(i in 1..N){
        s.add(sc.next())
    }
    var result = 0

    for(i in 1 .. M){
        if(s.contains(sc.next())){
            result++
        }
    }
    println(result)
}

