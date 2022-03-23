package m3w10

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

var col = 0
var row = 0
lateinit var map: Array<IntArray>
lateinit var outside: Array<BooleanArray>
val oddDx = intArrayOf(-1,0,1,1,0,-1)
val oddDy = intArrayOf(0,-1,0,1,1,1)
val evenDx = intArrayOf(-1,0,1,1,0,-1)
val evenDy = intArrayOf(-1,-1,-1,0,1,0)
lateinit var q : Queue<IntArray>

//참고 사이트 : https://velog.io/@paulus0617/boj5547

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())
    col = st.nextToken().toInt()
    row = st.nextToken().toInt()
    map1 = Array(row + 2) { IntArray(col + 2) }
    outside = Array(row + 2) { BooleanArray(col + 2) }
    for (i in 1 until row + 1) {
        st = StringTokenizer(br.readLine())
        for (j in 1 until col + 1) {
            map1[i][j] = st.nextToken().toInt()
        }
    }
    q = LinkedList()
    q.offer(intArrayOf(0, 0))
    outside[0][0] = true
    while (!q.isEmpty()) {
        val arr = q.poll()
        val cx = arr[0]
        val cy = arr[1]
        for (i in 0 until 6) {
            if (cx % 2 == 0) {
                checkOut(evenDx, evenDy, cx, cy, i)
            } else {
                checkOut(oddDx, oddDy, cx, cy, i)
            }
        }
    }
    var answer = 0
    for (i in 1 until row + 1) {
        for (j in 1 until col + 1) {
            if (map1[i][j] == 0) continue
            for (k in 0 until 6) {
                var nx = 0
                var ny = 0
                if (i % 2 == 0) {
                    nx = i + evenDx[k]
                    ny = j + evenDy[k]
                } else {
                    nx = i + oddDx[k]
                    ny = j + oddDy[k]
                }
                if (outside[nx][ny]) answer++
            }
        }
    }
    println(answer)
}

fun checkOut(dx: IntArray, dy: IntArray, cx: Int, cy: Int, i: Int) {
    val nx = cx + dx[i]
    val ny = cy + dy[i]
    if (nx >= 0 && nx <= row + 1 && ny >= 0 && ny <= col + 1) {
        if (!outside[nx][ny]) {
            if (map1[nx][ny] == 0) {
                outside[nx][ny] = true
                q.offer(intArrayOf(nx, ny))
            }
        }
    }
}