package level11

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main(){

    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())

    val n = st.nextToken().toInt()
    val target = st.nextToken().toInt()

    val card = IntArray(n)

    st = StringTokenizer(br.readLine())

    for( i in 0 until n){
        card[i] = st.nextToken().toInt()
    }

    var max = -1

    for(i in 0 until n){
        for(j in i+1 until n){
            for(k in j+1 until n){
                val sum = card[i] + card[j] + card[k]
                if(sum in max..target){
                    max = sum
                }
            }
        }
    }

    println(max)

}