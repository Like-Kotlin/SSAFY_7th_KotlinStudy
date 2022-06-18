package m6w17


import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

val check = BooleanArray(26)
lateinit var map: Array<CharArray>
var n = 0
var m = 0
var res = 0
val dx = intArrayOf(1, 0, -1, 0)
val dy = intArrayOf(0, 1, 0, -1)

fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(br.readLine())

    n = st.nextToken().toInt()
    m = st.nextToken().toInt()

    map = Array(n) { CharArray(m) }

    for (i in 0 until n) {
        val input = br.readLine()
        for (j in 0 until m) {
            map[i][j] = input[j]
        }
    }


    DFS(0, 0,1)

    println(res)

}

fun DFS(x: Int, y: Int , cnt : Int) {

    val ch = map[x][y]

    check[ch - 'A'] = true

    for (i in 0 until 4) {
        val nx = x + dx[i]
        val ny = y + dy[i]

        if (nx in 0 until n && ny in 0 until m) {
            if (!check[map[nx][ny] - 'A']){
                DFS(nx,ny,cnt+1)
            }
        }
    }

    check[ch - 'A'] = false

    res = res.coerceAtLeast(cnt)

}