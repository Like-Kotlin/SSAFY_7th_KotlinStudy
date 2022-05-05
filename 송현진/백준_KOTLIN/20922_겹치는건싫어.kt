import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    var br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())

    var N = st.nextToken().toInt()
    var num = st.nextToken().toInt()

    st = StringTokenizer(br.readLine())

    var arr = Array(N){0}
    for(i in 0 until N){
        arr[i] = st.nextToken().toInt()
    }

    var ans = 0
    var start = 0
    var end = 0
    var cnt = Array(100001){0}

    while(end < arr.size){
        //최장 연속 부분 수열 && 같은 숫자 num보다 작거나 같은 개수만 가지기
        //cnt[arr[end]] + 1 == +1 더한수가 정해진 num을 넘는지 확인
        while(end < arr.size && cnt[arr[end]] + 1 <= num){
            cnt[arr[end]]++
            end++
        }
        var len = end-start
        ans = Math.max(len,ans)
        //앞에서 하나씩 지우면서 start옮기기 -> 앞에서 하나씩 제거되면서 겹치던 숫자가 사라질 수 있음
        cnt[arr[start]]--
        start++

//        for(i in cnt.indices){
//            print("${cnt[i]} ")
//        }
//        println()
    }
    println(ans)
}