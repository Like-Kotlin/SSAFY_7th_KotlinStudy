import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    var st = StringTokenizer(readLine())
    var n = st.nextToken().toLong()
    var m = st.nextToken().toLong()

    var five = count5(n)
    var two = count2(n)

    five -= count5(m)
    five -= count5(n - m)

    two -= count2(m)
    two -= count2(n - m)

    if(five > two)
        print(two)
    else
        print(five)
}

fun count5(num: Long):Long{
    var cnt = 0L
    var n = num

    while(n >= 5){
        cnt += n / 5
        n /= 5
    }
    return cnt
}

fun count2(num: Long):Long{
    var cnt = 0L
    var n = num

    while(n >= 2){
        cnt += n / 2
        n /= 2
    }
    return cnt
}