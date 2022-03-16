package m3w11

import java.io.BufferedReader
import java.io.InputStreamReader

val num = intArrayOf(9,8,7,6,5,4,3,2,1,0)
val list = arrayListOf<Long>()

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val N = br.readLine().toInt()

    dfs(0,0)
    list.sort()

    if(N > 1023){
        println(-1)
    }else{
        println(list[N-1])
    }

}

fun dfs(res: Long, i: Int) {

    if(!list.contains(res)){
        list.add(res)
    }

    if(i >= 10){
        return
    }
    dfs(res*10 + num[i], i+1)
    dfs(res, i+1)
}
