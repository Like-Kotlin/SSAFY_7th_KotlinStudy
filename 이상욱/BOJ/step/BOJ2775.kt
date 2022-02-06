package level8

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(){

    val br = BufferedReader(InputStreamReader(System.`in`))
    val tc = br.readLine().toInt()

    for(t in 0 until tc){

        val k = br.readLine().toInt()
        val n = br.readLine().toInt()

        val home = Array(k+1){IntArray(n)}

        for( i in 0 until n ){

            home[0][i] = i+1

        }

        for(i in 1..k){
            for (j in 0 until n){
                home[i][j] = getSum(i-1,j,home)
            }
        }

        println(home[k][n-1])

    }

}

fun getSum(i: Int, n: Int, home: Array<IntArray>): Int {

    var sum = 0

    for(j in 0 .. n){
        sum+=home[i][j]
    }

    return sum
}
