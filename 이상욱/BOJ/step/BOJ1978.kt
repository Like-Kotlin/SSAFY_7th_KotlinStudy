package level9

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main(){

    val br = BufferedReader(InputStreamReader(System.`in`))

    val num = br.readLine().toInt()

    var cnt = 0

    val st = StringTokenizer(br.readLine())

    for(i in 0 until num){

        val n = st.nextToken().toInt()
        if(checkPrime(n)){
            cnt++
        }

    }

    println(cnt)

}

private fun checkPrime(n : Int) : Boolean{

    if(n == 1){
        return false
    }

    if(n == 2){
        return true
    }

    for(i in 2 .. Math.sqrt(n.toDouble()).toInt()){

        if(n % i == 0){
            return false
        }
    }

    return true
}