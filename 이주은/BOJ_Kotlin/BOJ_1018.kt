import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Integer.min
import java.util.*

fun main()=with(BufferedReader(InputStreamReader(System.`in`))){
    var st = StringTokenizer(readLine())

    var n = st.nextToken().toInt()
    var m = st.nextToken().toInt()

    var min = n * m
    val map = Array(n, {IntArray(m)})

    for(i in 0 until n){
        var line = readLine().toCharArray()

        for(j in 0 until m){
            if(((i + j) % 2 == 0 && line[j] != 'W') ||
                ((i + j) % 2 != 0 && line[j] != 'B')){
                map[i][j]++
            }

            if (j > 0)
                map[i][j] += map[i][j - 1]
        }
    }

    for(i in 0..n - 8){
        for(j in 0..m - 8){
            var cnt = 0

            for(k in i until i + 8){
                cnt += map[k][j + 7]
                if(j > 0)
                    cnt -= map[k][j - 1]
            }

            if(cnt > 64 - cnt)
                cnt = 64 - cnt

            min = min(cnt, min)
        }
    }
    println(min)

}