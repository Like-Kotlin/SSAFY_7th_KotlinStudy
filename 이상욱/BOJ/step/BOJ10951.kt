package level4

import java.io.*

//더하기 사이클
fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))

    val N = br.readLine().toInt()
    var n = N
    var cnt = 0


    while (true) {

        n = if (n < 10) {
            "${n}${n}".toInt()

        } else {
            val first = ((n.toString()[0] - '0') + (n.toString()[1] - '0')).toString()
            "${n.toString()[1]}${first[first.length - 1]}".toInt()

        }
        cnt++

        if (N == n) {
            break
        }
    }

    print(cnt)

}