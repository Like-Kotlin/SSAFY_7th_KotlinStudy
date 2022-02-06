import java.io.BufferedReader
import java.io.InputStreamReader
import java.text.DecimalFormat
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    var t = readLine()!!.toInt()
    while(t --> 0){
        val st = StringTokenizer(readLine())
        var n = st.nextToken().toInt()
        val students = IntArray(n)
        var sum = 0.0

        for(i in 0 until n){
            students.set(i, st.nextToken().toInt())
            sum += students[i]
        }

        sum /= n

        var cnt = 0
        for(i in students){
            if(sum < i)
                cnt++
        }

        println(String.format("%.3f%%", 100.000 * cnt / n))
    }
}