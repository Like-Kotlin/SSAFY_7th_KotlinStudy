import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

var cnt = 0
var result = 0
var A = 0
var B = 0
fun main() {
    var br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())

    var s1 = st.nextToken()
    var s2 = st.nextToken()

    //각자리 진법 계산해 넣은 배열
    var s1Arr = calN(s1)
    var s2Arr = calN(s2)

    //같은 10진수를 가진 횟수 계산
    findCnt(s1Arr, s2Arr)

    //결과 출력
    printResult()
}

fun calN(s: String):Array<Int>{
    // Int범위 넘어가면 try catch 로 예외처리해서 끝까지 돌기
    var arr =  Array(37){-1}

    //2진법~ 36진법
    for(i in 2..36){
        try{
            //들어온 문자열을 i자리 진법으로 변환
            arr[i] = Integer.parseInt(s, i)
        }catch(e: Exception){
            //Int 범위 넘을 경우 예외로 패스
            continue
        }
    }
    return arr
}

fun findCnt(s1Arr:Array<Int>, s2Arr:Array<Int>){

    for (i in s1Arr.indices) {
        //-1이면 패스
        if (s1Arr[i] == -1) {
            continue
        }
        for (j in s2Arr.indices) {
            //-1값이면 패스
            if (s2Arr[j] == -1) {
                continue
            }

            //10진수 변환한 값이 같고 각 진법이 다르면
            if (s1Arr[i] == s2Arr[j] && i != j) {
                //횟수 추가 및 출력에 필요한 값들 저장
                cnt++
                result = s1Arr[i]
                A = i
                B = j
            }
        }
    }
}

fun printResult() =
    when (cnt) {
        0 -> {
            print("Impossible")
        }
        1 -> {
            print("$result $A $B")
        }
        else -> {
            print("Multiple")
        }
    }
