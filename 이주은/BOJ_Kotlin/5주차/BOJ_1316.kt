import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    var n = readLine().toInt()
    var cnt = 0

    for(i in 1..n){
        var str = readLine().toCharArray()
        var s = str[0] + ""
        var flag = true

        for(j in 1 until str.size){
            if(str[j - 1] != str[j]){
                if(s.contains(str[j])) {
                    flag = false
                    break
                }
                s += str[j]
            }
        }

        if(flag)
            cnt++
    }

    println(cnt)
}