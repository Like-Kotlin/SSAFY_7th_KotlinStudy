import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*


fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))

    var a = br.readLine()
    var b = br.readLine()

    val a_arr = mutableListOf<Char>()
    val b_arr = mutableListOf<Char>()

    a_arr.add('A')
    b_arr.add('A')

    for(i in a.iterator()){
        a_arr.add(i)
    }
    for(i in b.iterator()){
        b_arr.add(i)
    }
    val a_len = a.length
    val b_len = b.length

    var dp =  Array<IntArray>(b_len + 1, {IntArray(a_len + 1)})

    for(i in 1..b_len){
        for(j in 1..a_len){
            if(b_arr[i] == a_arr[j]){
                dp[i][j] = dp[i-1][j-1] + 1;
            }else{
                dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1])
            }
        }
    }

    println(dp[b_len][a_len])
}

