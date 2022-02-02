package level14

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

var max1 = -1000000000
var min1 = 1000000000
var N = 0
lateinit var numArr: IntArray
lateinit var calcArr: IntArray
fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))
    N = br.readLine().toInt()
    numArr = IntArray(N)

    var st = StringTokenizer(br.readLine())
    for (i in 0 until N) {
        numArr[i] = st.nextToken().toInt()
    }

    calcArr = IntArray(4)
    st = StringTokenizer(br.readLine())
    for (i in 0 until 4) {
        calcArr[i] = st.nextToken().toInt()
    }


    calc(1, numArr[0])

    println(max1)
    println(min1)

}

private fun calc(idx: Int, num: Int) {

    if (idx == N) {
        if (num > max1) max1 = num

        if (num < min1) min1 = num

        return
    }

    for (i in 0 until 4) {
        if (calcArr[i] != 0) {

            when (i) {
                0 -> {
                    calcArr[i]--
                    calc(idx + 1, num + numArr[idx])
                    calcArr[i]++
                }


                1 -> {
                    calcArr[i]--
                    calc(idx + 1, num - numArr[idx])
                    calcArr[i]++
                }


                2 -> {
                    calcArr[i]--
                    calc(idx + 1, num * numArr[idx])
                    calcArr[i]++
                }


                3 -> {
                    calcArr[i]--
                    calc(idx+1,num / numArr[idx])
                    calcArr[i]++
                }


            }
        }
    }


}
