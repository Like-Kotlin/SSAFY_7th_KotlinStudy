package m4w12

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

val br = BufferedReader(InputStreamReader(System.`in`))
lateinit var st : StringTokenizer

var n = 0
var m = 0
lateinit var map : Array<IntArray>
lateinit var copy : Array<IntArray>
val virusList = arrayListOf<IntArray>()

val dx = intArrayOf(0,1,0,-1)
val dy = intArrayOf(1,0,-1,0)

var max = 0
fun main(){

    init()

    setWall(0,0)

    println(max)

}

private fun setWall(idx : Int , cnt : Int){

    if(cnt == 3){

        copyMap()
        spread()
        getSafeArea()

        return
    }

    for(i in idx until n*m){

        val row = i / m
        val col = i % m

        if(map[row][col] == 0){
            map[row][col] = 1
            setWall(idx+1,cnt+1)
            map[row][col] = 0

        }

    }

}

private fun getSafeArea(){
    var cnt = 0
    for(i in 0 until n){
        for(j in 0 until m){
            if(copy[i][j] == 0){
                cnt++
            }
        }
    }

    max = Math.max(cnt,max)

}


private fun spread(){

    virusList.forEach{virus ->
        val x = virus[0]
        val y = virus[1]

        dfs(x,y)
    }

}

private fun dfs(x : Int, y : Int){

    for(i in 0 until 4){
        val nx = x + dx[i]
        val ny = y + dy[i]

        if(nx in 0 until n && ny in 0 until m){
            if(copy[nx][ny] == 0){
                copy[nx][ny] = 2
                dfs(nx,ny)
            }
        }
    }


}

private fun copyMap(){

    for(i in 0 until n){
        for(j in 0 until m){
            copy[i][j] = map[i][j]
        }
    }

}

private fun init(){

    st = StringTokenizer(br.readLine())
    n = st.nextToken().toInt()
    m = st.nextToken().toInt()

    map = Array(n){IntArray(m)}
    copy = Array(n){IntArray(m)}
    repeat(n){i ->
        st = StringTokenizer(br.readLine())
        repeat(m){j ->
            map[i][j] = st.nextToken().toInt()
            if(map[i][j] == 2){
                virusList.add(intArrayOf(i,j))
            }

        }
    }

}