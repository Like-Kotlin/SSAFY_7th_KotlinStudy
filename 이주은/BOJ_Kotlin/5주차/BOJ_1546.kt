import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val n = readLine()!!.toInt()
    var score = readLine()!!.split(" ").map { it.toDouble() }.toMutableList()
    var max = 0.0;
    var sum = 0.0;

    for(i in 0 until n){
        max = max(score[i], max)
    }

    for(i in 0 until n){
        score[i] = score[i] / max * 100
    }

    for(i in 0 until n){
        sum += score[i]
    }

    print(sum / n)
}