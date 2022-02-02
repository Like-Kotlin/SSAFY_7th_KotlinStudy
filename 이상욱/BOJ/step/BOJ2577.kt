package level5

import java.io.*

fun main(){

    val br = BufferedReader(InputStreamReader(System.`in`))

    val cnt = IntArray(10)

    val a = br.readLine().toInt()
    val b = br.readLine().toInt()
    val c = br.readLine().toInt()

    val num = a * b * c

    val str = num.toString()

    for(i in str.indices){

        cnt[str[i]-'0']++

    }

    cnt.forEach {
        println(it)
    }


}