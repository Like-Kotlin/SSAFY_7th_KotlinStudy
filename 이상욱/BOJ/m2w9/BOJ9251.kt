package m2w9

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))

    val str1 = br.readLine()
    val str2 = br.readLine()

    val arr = Array(str1.length+1){ IntArray(str2.length+1) }

    for(i in 1..str1.length){
        for(j in 1..str2.length){
            if(str1[i-1] == str2[j-1]){
                arr[i][j] = arr[i-1][j-1]+1
            }else{
                arr[i][j] = arr[i - 1][j].coerceAtLeast(arr[i][j - 1])
            }

        }
    }

    println(arr[str1.length][str2.length])

}