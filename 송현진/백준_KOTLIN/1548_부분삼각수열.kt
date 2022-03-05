import o.Companion.list
import o.Companion.result
import o.Companion.N
import java.util.*
import java.io.*
import kotlin.collections.ArrayList

class o{
    companion object{
        var list = ArrayList<Int>()
        var result = 1
        var N:Int = 0
    }
}

fun main(){
    var br = BufferedReader(InputStreamReader(System.`in`))
    N = br.readLine().toInt()

    var st = StringTokenizer(br.readLine()," ")
    for(i in 1..N){
        list.add(st.nextToken().toInt())
    }
    list.sort()

    cal()

    if(result == 1 && N >= 2){
        result = 2
    }

    println(result)
}

fun cal(){
    //완전탐색
    //정렬된 리스트의 앞부터 시작해서 탐색
    for(i in 0 until N-1){
        //정렬된 수열의 뒤부터 탐색
        for(j in N-1 downTo 0){
            if(i+1 == j) break// 중간 넘으면 탈출
            //x+y>z 만족할때까지 뒤에서부터 찾기
            if(list[i] + list[i+1] > list[j]){
                //찾으면 기존 result와 비교해서 값 넣기
                result = Math.max(result, j-i+1)
                //찾았으니 다음 수 탐색 실시
                break
            }
        }
    }
}