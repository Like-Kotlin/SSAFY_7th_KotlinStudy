package level5

import java.io.*

fun main(){

    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()


    for(i in 0 until n){
        var sum = 0
        var cnt = 0

        val ox = br.readLine()
        ox.forEach {
            if (it == 'O'){
                cnt++
                sum+=cnt
            }else{
                cnt = 0

            }
        }

        println(sum)

    }

}