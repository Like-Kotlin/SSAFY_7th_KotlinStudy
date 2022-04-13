package step

import java.util.*

private val br = System.`in`.bufferedReader()

fun main() {
    // 현재 시각
    val st = StringTokenizer(br.readLine())
    var hour : Int = Integer.parseInt(st.nextToken())
    val min : Int = Integer.parseInt(st.nextToken())
    // 소요시간
    val time : Int = Integer.parseInt(br.readLine())

    var need_hour : Int = time / 60
    hour += need_hour
    var need_min : Int = time.mod(60)

    var plus_hour : Int = min.plus(need_min) / 60

    var result_min = min.plus(need_min).mod(60)
    var result_hour : Int = hour.plus(plus_hour).mod(24)

    print("${result_hour} ${result_min}")
}