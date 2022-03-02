package `9주차`


/** 참고자료: https://meoru-tech.tistory.com/62 */

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.collections.ArrayList

fun main()=with(BufferedReader(InputStreamReader(System.`in`))){
    val n = readLine().toInt()
    val room = Array(n){ Array(n) {0} }
    val table = Array(n * n) { Array(5) {0} }
    var satisfaction = 0

    for(i in 0 until n * n){
        var st = StringTokenizer(readLine())
        for(j in 0 until 5){
            table[i][j] = st.nextToken().toInt()
        }
    }

    for(i in 0 until n * n){
        arrangeSeat(room, table[i], n)
    }

    for(i in 0 until n){
        for(j in 0 until n){
            var k = 0
            while(table[k][0] != room[i][j])
                k++

            val student = table[k]
            satisfaction += satisfy(room, student, i, j, n)
        }
    }
    println(satisfaction)
}

/* 만족도의 총 합을 구함 */
fun satisfy(room: Array<Array<Int>>, student: Array<Int>, i: Int, j: Int, n: Int): Int {
    var friends = 0
    if(i > 0 && student.contains(room[i - 1][j])){
        friends++
    }

    if(i < n - 1 && student.contains(room[i + 1][j])){
        friends++
    }

    if(j > 0 && student.contains(room[i][j - 1])){
        friends++
    }
    if(j < n - 1 && student.contains(room[i][j + 1])){
        friends++
    }

    when(friends){
        1 -> return 1
        2 -> return 10
        3 -> return 100
        4 -> return 1000
    }
    return 0
}


fun arrangeSeat(room: Array<Array<Int>>, table: Array<Int>, n:Int){
    val student = rule1(room, table, n)
    if(student.size != 1) rule2(room, student, n)
    if(student.size != 1) rule3(student)

    val i = student[0].first
    var j = student[0].second
    room[i][j] = table[0]
    return
}

/* 규칙1: 비어있는 칸 중에서 좋아하는 학생이 인접한 칸에 가장 많은 칸으로 자리를 정한다. */
fun rule1(room: Array<Array<Int>>, table: Array<Int>, n: Int): ArrayList<Pair<Int, Int>>{
    var result = ArrayList<Pair<Int, Int>>()
    var near = 0

    for(i in 0 until n){
        for(j in 0 until n){
            var friends = 0

            // 좋아하지 않는 학생의 경우 continue
            if(room[i][j] != 0)
                continue

            // room[i][j]의 상하좌우에 해당 학생의 친구가 있으면 friends + 1
            if(i > 0 && table.contains(room[i - 1][j])){
                friends++
            }

            if(i < n - 1 && table.contains(room[i + 1][j])){
                friends++
            }

            if(j > 0 && table.contains(room[i][j - 1])){
                friends++
            }
            if(j < n - 1 && table.contains(room[i][j + 1])){
                friends++
            }

            // friends가 near보다 크면 near Update
            near = if(near >= friends) near
                   else friends
        }
    }

    // 위에서 구한 near값과 friends 값이 같은 좌표를 리스트에 추가
    for(i in 0 until n){
        for(j in 0 until n){
            var friends = 0
            if(room[i][j] != 0)
                continue
            if(i > 0 && table.contains(room[i - 1][j])){
                friends++
            }

            if(i < n - 1 && table.contains(room[i + 1][j])){
                friends++
            }

            if(j > 0 && table.contains(room[i][j - 1])){
                friends++
            }
            if(j < n - 1 && table.contains(room[i][j + 1])){
                friends++
            }

            if(near == friends)
                result.add(Pair(i, j))
        }
    }
    return result
}

/* 규칙2: 규칙1을 만족하는 칸이 여러 개이면, 인접한 칸 중에서 비어있는 칸이 가장 많은 칸으로 자리를 정한다. */
fun rule2(room: Array<Array<Int>>, student: ArrayList<Pair<Int, Int>>, n: Int) {
    var empty = 0

    for(t in student.indices){
        var e = 0
        var i = student[t].first
        var j = student[t].second

        if(i > 0 && room[i - 1][j] == 0) e++
        if(i < n - 1 && room[i + 1][j] == 0) e++
        if(j > 0 && room[i][j - 1] == 0) e++
        if(j < n - 1 && room[i][j + 1] == 0) e++

        empty = if(empty >= e) empty
                else e
    }

    for(t in student.size - 1 downTo 0){
        var e = 0
        var i = student[t].first
        var j = student[t].second

        if(i > 0 && room[i - 1][j] == 0) e++
        if(i < n - 1 && room[i + 1][j] == 0) e++
        if(j > 0 && room[i][j - 1] == 0) e++
        if(j < n - 1 && room[i][j + 1] == 0) e++

        if(empty > e) student.removeAt(t)
    }
}

/* 규칙3: 규칙2를 만족하는 칸도 여러 개인 경우에는 행의 번호가 가장 작은 칸으로, 그러한 칸도 여러 개이면 열의 번호가 가장 작은 칸으로 자리를 정한다. */
fun rule3(student: ArrayList<Pair<Int, Int>>){
    var min = Int.MAX_VALUE
    for(t in student.indices){
        min = if(min <= student[t].first) min
              else student[t].first
    }

    for(t in student.size - 1 downTo 0){
        if(min != student[t].first) student.removeAt(t)
    }

    while(student.size != 1){
        if(student[0].second > student[1].second)
            student.removeAt(0)
        else
            student.removeAt(1)
    }
}
