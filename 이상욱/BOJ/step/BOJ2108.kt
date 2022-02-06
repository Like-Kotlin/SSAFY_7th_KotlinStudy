package level12

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.collections.HashMap
import kotlin.math.roundToInt

fun main(){

    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()

    val arr = IntArray(n)

    for(i in 0 until n){

        arr[i] = br.readLine().toInt()

    }

    val hm = HashMap<Int,Int>()

    arr.forEach {
        if(hm.containsKey(it)){
            hm[it] = hm[it]!!.plus(1)
        }else{
            hm[it] = 1
        }
    }

    val list = hm.toList().sortedByDescending { it.second }
    val max = list[0].second

    val ansList  = arrayListOf<Int>()

    list.forEach{
        if(it.second == max){
            ansList.add(it.first)
        }
    }

    ansList.sort()

    val maxIdx = if(ansList.size == 1){
        ansList[0]
    }else{
        ansList[1]
    }

    println(arr.average().roundToInt())
    println(arr.sorted()[arr.size/2])
    println(maxIdx)
    println(arr.maxOrNull()!! - arr.minOrNull()!!)

}