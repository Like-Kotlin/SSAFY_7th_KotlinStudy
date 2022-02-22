package m2w8

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))
    var st : StringTokenizer

    val T = br.readLine().toInt()

    repeat(T){
        st = StringTokenizer(br.readLine())
        val n = st.nextToken().toInt()

        val arr = IntArray(n)

        for (i in 0 until n){
            arr[i] = st.nextToken().toInt()
        }

        var sum = 0L
        for(i in 0 until n){
            for(j in i+1 until n){
                sum += getGCD(arr[i],arr[j])
            }
        }
        println(sum)
    }
}

fun getGCD(num1 : Int, num2 : Int) : Int{

    return  if (num1 < num2){
        if(num1 == 0) num2 else getGCD(num1, num2 % num1)
    }else{
        if(num2 == 0) num1 else getGCD(num2, num1 % num2)
    }


}