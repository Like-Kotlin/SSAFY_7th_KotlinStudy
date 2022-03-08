package `10주차`

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

var h: Int = 0
var w: Int = 0
lateinit var map: Array<Array<Int>>
lateinit var visited: Array<Array<Boolean>>

/** Q1. 왜 코틀린은 Queue<IntArray>가 안 되는 걸까?
 *
 * 일단 Queue<IntArray>가 안 되서 qx와 qy로 나눔
 * */
lateinit var qx: Queue<Int>
lateinit var qy: Queue<Int>

fun main()=with(BufferedReader(InputStreamReader(System.`in`))){
    var st = StringTokenizer(readLine())
    w = st.nextToken().toInt()
    h = st.nextToken().toInt()

    map = Array<Array<Int>>(h + 2, { Array<Int>(w + 2, { 0 } ) })
    visited = Array<Array<Boolean>>(h + 2, {Array<Boolean>(w + 2, {false})})
    qx = LinkedList()
    qy = LinkedList()

    var odd = arrayOf(  arrayOf(-1, 0), arrayOf(0, -1), arrayOf(1, 0),
                        arrayOf(1, 1), arrayOf(0, 1), arrayOf(-1, 1))
    var even = arrayOf( arrayOf(-1, -1), arrayOf(0, -1), arrayOf(1, -1),
                        arrayOf(1, 0), arrayOf(0, 1), arrayOf(-1, 0))


    for(i in 1..h){
        st = StringTokenizer(readLine())
        for(j in 1..w){
            map[i][j] = st.nextToken().toInt()
        }
    }

    qx.offer(0)
    qy.offer(0)
    visited[0][0] = true

    while(!qx.isEmpty()){
        var now_x = qx.poll()
        var now_y = qy.poll()
        println(now_x.toString() + " "  + now_y)

        for(i in 0 until 6){
            if(now_x % 2 == 0)
                checkOuter(even, now_x, now_y, i)
            else
                checkOuter(odd, now_x, now_y, i)
        }
    }

    var answer = 0
    for(i in 1 until h + 1){
        for(j in 1 until w + 1){
            if(map[i][j] == 0)
                continue

            for(n in 0 until 6){
                var r = 0
                var c = 0

                if(i % 2 == 0){
                    r = i + even[n][0]
                    c = j + even[n][1]
                } else{
                    r = i + odd[n][0]
                    c = j + odd[n][1]
                }

                if(visited[r][c])
                    answer++
            }
        }
    }
    println(answer)
}

fun checkOuter(dir: Array<Array<Int>>, nowX: Int, nowY: Int, i: Int) {
    var x = nowX + dir[i][0]
    var y = nowY + dir[i][1]
    if(x < 0 || x > h + 1 || y < 0 || y > w + 1)
        return

    if(!visited[x][y]){
        if(map[x][y] == 0){
            visited[x][y] = true
            qx.offer(x)
            qy.offer(y)
            //println(x.toString() + " " + y)
        }
    }
}
