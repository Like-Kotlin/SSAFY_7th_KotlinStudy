package m2w9

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*


lateinit var like: Array<IntArray>
lateinit var map: Array<IntArray>
val dx = intArrayOf(1, 0, -1, 0)
val dy = intArrayOf(0, 1, 0, -1)
var n = 0
var answer = 0

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st: StringTokenizer
    n = br.readLine().toInt()
    map = Array(n + 1) { IntArray(n + 1) }

    like = Array(n * n) { IntArray(5) }

    for (i in 0 until n * n) {
        st = StringTokenizer(br.readLine())
        for (j in 0 until 5) {
            like[i][j] = st.nextToken().toInt()
        }
    }

    like.forEach { arr ->
        find(arr)

    }

    like.sortWith(compareBy { it[0] })

    for (i in 1..n) {
        for (j in 1..n) {
            val stu = map[i][j]
            val arr = like[stu - 1]
            var cnt = 0
            for (k in 0 until 4) {

                val nx = i + dx[k]
                val ny = j + dy[k]
                if (nx in 1..n && ny in 1..n) {
                    if (arr.contains(map[nx][ny])) {
                        cnt++
                    }
                }
            }
            when (cnt) {
                0 -> answer += 0
                1 -> answer += 1
                2 -> answer += 10
                3 -> answer += 100
                4 -> answer += 1000
            }
        }
    }
    println(answer)
}

fun find(arr: IntArray) {
    val stu = arr[0]
    val list = arrayListOf<Pair<Int, Int>>()

    var max = 0

    for (i in 1..n) {
        for (j in 1..n) {
            if (map[i][j] == 0) {
                var cnt = 0
                for (k in 0 until 4) {
                    val nx = i + dx[k]
                    val ny = j + dy[k]

                    if (nx in 1..n && ny in 1..n) {
                        if (arr.contains(map[nx][ny])) {
                            cnt++
                        }
                    }
                }

                if (max < cnt) {
                    max = cnt
                    list.clear()
                    list.add(Pair(i, j))
                } else if (max == cnt) {
                    list.add(Pair(i, j))
                }


            }
        }
    }

    if (list.size == 1) {
        val row = list[0].first
        val col = list[0].second
        map[row][col] = stu
        return
    }

    var cntBlank = 0
    var maxBlank = 0
    val blankList = arrayListOf<Pair<Int, Int>>()

    //빈칸 많은 좌표 찾기
    list.forEach { pair ->
        val x = pair.first
        val y = pair.second

        for (i in 0 until 4) {
            val nx = x + dx[i]
            val ny = y + dy[i]

            if (nx in 1..n && ny in 1..n) {
                if (map[nx][ny] == 0) {
                    cntBlank++
                }
            }
        }

        if (cntBlank > maxBlank) {
            blankList.clear()
            blankList.add(Pair(x, y))
            maxBlank = cntBlank

        } else if (cntBlank == maxBlank) {
            blankList.add(Pair(x, y))
        }
        cntBlank = 0
    }

    blankList.sortWith(compareBy(
        { it.first },
        { it.second }
    ))

    val row = blankList[0].first
    val col = blankList[0].second
    map[row][col] = stu

}
