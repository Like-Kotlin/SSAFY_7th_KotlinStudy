package level14

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.collections.ArrayList

val br = BufferedReader(InputStreamReader(System.`in`))
lateinit var st : StringTokenizer
var n = 0
var min = 1000
lateinit var stats : Array<IntArray>
lateinit var arr1: IntArray
lateinit var visit : BooleanArray
var team = arrayListOf<ArrayList<Int>>()

fun main(){

    n = br.readLine().toInt()
    stats = Array(n){IntArray(n)}
    arr1 = IntArray(n)
    visit = BooleanArray(n)

    for(i in 0 until n){
        st = StringTokenizer(br.readLine())
        for(j in 0 until n){
            stats[i][j] = st.nextToken().toInt()
        }
    }

    for(i in 0 until n){
        arr1[i] = i
    }

    comb(arr1,visit,0,n,n/2)

    for(i in 0 until team.size/2){
        val teamStart = team[i]
        val teamLink = team[team.size-1-i]

        val score = getScore(teamStart,teamLink)

        if(min > score) min = score
    }

    println(min)


}

private fun getScore(start : ArrayList<Int>, link : ArrayList<Int>) : Int{

    var scoreStart = 0
    var scoreLink = 0

    for(i in 0 until start.size-1){
        for(j in i+1 until start.size){
            scoreStart += stats[start[i]][start[j]]+stats[start[j]][start[i]]
        }
    }

    for(i in 0 until link.size-1){
        for(j in i+1 until link.size){
            scoreLink += stats[link[i]][link[j]]+stats[link[j]][link[i]]
        }
    }

    return Math.abs(scoreStart - scoreLink)

}

private fun comb(arr : IntArray, visit : BooleanArray, start : Int, n : Int, r : Int){

    if(r == 0){
        val tmpList = arrayListOf<Int>()
        for(i in visit.indices){
            if(visit[i]){
                tmpList.add(arr[i])
            }
        }
        team.add(tmpList)
    }

    for(i in start until n){
        if(!visit[i]){
            visit[i] = true
            comb(arr,visit,i+1,n,r-1)
            visit[i] = false
        }
    }

}