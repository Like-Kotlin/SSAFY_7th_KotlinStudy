package m4w11

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

var max = -1
var N = 0
var k = 0
val visit = IntArray(100001)
fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())

    N = st.nextToken().toInt()
    k = st.nextToken().toInt()

    val arr = IntArray(N)

    st = StringTokenizer(br.readLine())

    for (i in 0 until N) {
        arr[i] = st.nextToken().toInt()
    }

    var start = 0
    var end = 0
    var len = 0

    while (end != N) {

        if (visit[arr[end]] < k) {
            visit[arr[end]]++
            end++
            len++
            max = Math.max(max, len)
        } else {
            visit[arr[start]]--
            start++
            len--
        }

    }

    print(max)

}

