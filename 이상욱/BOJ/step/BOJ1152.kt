package level7

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(){

    val br = BufferedReader(InputStreamReader(System.`in`))

    val sentence = br.readLine().trim()

    if(sentence == ""){
        println(0)
        return
    }

    val size = sentence.split(" ").size

    println(size)

}