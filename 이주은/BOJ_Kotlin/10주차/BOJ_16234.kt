package `10주차`

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

class Pos(x: Int, y: Int){
    var x: Int = x
    var y: Int = y
}

var n = 0
var l = 0
var r = 0
lateinit var map_: Array<Array<Int>>
lateinit var visited_: Array<Array<Boolean>>
var dx = arrayOf(0, 0, -1, 1)
var dy = arrayOf(1, -1, 0, 0)

fun main()=with(BufferedReader(InputStreamReader(System.`in`))){
    var st = StringTokenizer(readLine())
    n = st.nextToken().toInt()
    l = st.nextToken().toInt()
    r = st.nextToken().toInt()

    map_ = Array<Array<Int>>(n, { Array<Int>(n, {0} )})

    for(i in 0 until n){
        st = StringTokenizer(readLine())
        for(j in 0 until n){
            map_[i][j] = st.nextToken().toInt()
        }
    }

    var cnt = count()

    println(cnt)
}

fun count(): Int{
    var cnt = 0
    var flag = false

    while(true){
        visited_ = Array<Array<Boolean>>(n, {Array<Boolean>(n, {false})})
        flag = false

        for(i in 0 until n){
            for(j in 0 until n){
                if(visited_[i][j])
                    continue
                if(open(i, j))
                    flag = true
            }
        }
        if(flag) cnt += 1
        else
            break
    }
    return cnt
}

fun open(x: Int, y: Int): Boolean{
    var q:Queue<Pos> = LinkedList()
    var list:Queue<Pos> = LinkedList()

    q.add(Pos(x, y))
    list.add(Pos(x, y))
    visited_[x][y] = true

    var sum = map_[x][y]

    while(!q.isEmpty()){
        var now = q.poll()

        for(i in 0 until 4){
            var xx = now.x + dx[i]
            var yy = now.y + dy[i]

            if(xx < 0 || xx >= n || yy < 0 || yy >= n || visited_[xx][yy])
                continue

            var diff = Math.abs(map_[now.x][now.y] - map_[xx][yy])

            if(l > diff || r < diff)
                continue

            sum += map_[xx][yy]
            q.add(Pos(xx, yy))
            list.add(Pos(xx, yy))
            visited_[xx][yy] = true
        }
    }

    if(list.size == 1)
        return false
    else{
        sum /= list.size
        for(i in 0 until list.size){
            var idx = list.poll()
            map_[idx.x][idx.y] = sum
        }
        return true
    }
}