import java.util.*
import java.io.*
fun main(){
    var br = BufferedReader(InputStreamReader(System.`in`))
    var N = br.readLine().toInt()

    var arr = Array(N){0.0}

    var st = StringTokenizer(br.readLine()," ")
    for(i in 0 until N){
        arr[i] = st.nextToken().toDouble()
    }

    Arrays.sort(arr);

    var sum = 0.0
    //크기 순으로 정렬한 후 마지막 가장 큰 양의 드링크 제외한 나머지 드링크는 반으로 나누어서 sum에 더한다.
    for(i in 0 until N){
        sum += if(i == N-1) arr[N-1]
        else{
            arr[i]/(2.0)
        }
    }
    println(sum)
}
