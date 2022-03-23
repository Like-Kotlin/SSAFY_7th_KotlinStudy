package m3w11

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

var answer = 0
fun main(){

    val br = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(br.readLine())

    val N = st.nextToken().toInt()
    val r = st.nextToken().toInt()
    val c = st.nextToken().toInt()

    val mapSize = (Math.pow(2.0, N.toDouble())).toInt()
    
    checkZ(mapSize,r,c)
    println(answer)

}

fun checkZ(mapSize: Int, r: Int, c: Int) {

    if(mapSize == 1){
        return
    }
    if(r < mapSize / 2 && c < mapSize / 2){
        checkZ(mapSize / 2,r,c)
    }else if(mapSize / 2 in (r + 1)..c){
        answer += mapSize * mapSize / 4
        checkZ(mapSize / 2 , r, c - mapSize/2)
    }else if(mapSize/2 in (c + 1)..r){
        answer += (mapSize * mapSize / 4) * 2
        checkZ(mapSize / 2, r - mapSize / 2, c)
    }else{
        answer += (mapSize * mapSize) / 4 * 3
        checkZ(mapSize / 2, r - mapSize / 2 , c - mapSize/2)
    }

}
