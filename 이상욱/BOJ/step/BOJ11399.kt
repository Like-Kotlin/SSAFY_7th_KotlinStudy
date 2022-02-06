package level16

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*


fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))
    val num = br.readLine().toInt()

    val arr = IntArray(num)
    val sum = IntArray(num)

    val st = StringTokenizer(br.readLine())

    for (i in 0 until num){

        arr[i] = st.nextToken().toInt()

    }

    Arrays.sort(arr)

    sum[0] = arr[0]
    var res = arr[0]

    for (i in 1 until  arr.size){
        sum[i] = arr[i] + sum[i-1]
        res += sum [i]
    }

    println(res)

}