import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.round
import kotlin.math.sqrt

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val t = readLine().toInt()

    for(i in 1..t){
        var st = StringTokenizer(readLine());
        var x = st.nextToken().toInt()
        var y = st.nextToken().toInt()

        var diff = y - x;               // 이동해야 할 총 거리
        var max = sqrt(diff.toDouble()) // 총 거리의 절반에서 부터는 이동 거리를 1씩 줄여서 이동해야 한다.
        var up = round(max)             // 이동 할 수 있는 거리의 최대값

        if(diff <= 3)
            println(diff)
        else if (max > up)
            println(up.toInt() * 2)
        else if (max <= up)
            println(up.toInt() * 2 - 1)
    }
}