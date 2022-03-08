package `10주차`

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main()= with(BufferedReader(InputStreamReader(System.`in`))){
    val n = readLine().toInt()

    val arr = IntArray(n)
    var st = StringTokenizer(readLine())

    for(i in 0 until n){
        arr[i] = st.nextToken().toInt()
    }

    Arrays.sort(arr)
    var cnt = 1

    for(first in 0 until n - 1){
        for(third in n - 1 downTo 0){
            if(first + 1 == third)
                break

            if(arr[first] + arr[first + 1] > arr[third]){
                cnt = Math.max(cnt, third - first + 1)
                break
            }
        }
    }

    if(cnt == 1 && n >= 2)
        cnt = 2

    print(cnt)
}