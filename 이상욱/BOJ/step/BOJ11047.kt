package level16

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main(){

    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())

    val num = st.nextToken().toInt()
    var money = st.nextToken().toInt()

    val coin = IntArray(num)

    for(i in 1 until num+1){

        st = StringTokenizer(br.readLine())
        coin[num-i] = st.nextToken().toInt()

    }

    var cnt = 0

    while(money != 0){

        for(i in coin.indices){

            if(money >= coin[i]){
                cnt += money/coin[i]
                money %= coin[i]
            }

        }

    }

    println(cnt)

}