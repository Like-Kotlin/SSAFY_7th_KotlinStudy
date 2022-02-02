package level7

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))

    val word = br.readLine()
    println(word)

    val arr = IntArray(27)

    for (i in word.indices) {

        arr[word[i]-'a']++

    }
    var max = -1
    var index = 0

    arr.forEachIndexed { idx, num ->

        if (num > max) {
            max = num
            index = idx
        }
    }
   arr.sortDescending()
    if (arr[0] == arr[1]) {
        println("?")

    }else{
        println('A'+(index))
    }

}