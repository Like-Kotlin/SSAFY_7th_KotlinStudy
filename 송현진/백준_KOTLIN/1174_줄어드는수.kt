import java.io.*
import java.util.*
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

fun main(){
    var br = BufferedReader(InputStreamReader(System.`in`))
    var N = br.readLine().toInt()
    var num = arrayOf(9,8,7,6,5,4,3,2,1,0);
    var arr = ArrayList<Long>() //일반 정적 배열로 만들면 0이 하나 더 추가되어서 정렬 시 0이 두개가 된다.

    //num배열의 10자리를 모두 중복없이 쓰려면 2^10 번 == 1024번 돌게된다.
    for(i in 1 until (1 shl 10)){//shl == shift left
        var sum:Long = 0
        //0~9까지 10자리를 돈다.
        for(j in 0..9){
            //만약 i의 해당 자리가 1이라면 j만큼 1을 민 곳 자리랑 and 연산을 하게되어 0보다 값이 커진다.
            if( (i and (1 shl j)) > 0){
                //해당 자리의 수를 찾아 배열에 넣어준다.
                //이때 j는 계속 커지므로 sum에 넣어지는  값은 9~0까지 점차 작아지게 된다.
                sum = sum * 10 + num[j]
            }
        }
        arr.add(sum)
    }
    //정렬해준다.
    arr.sort()
    //1024크기보다 큰 값이 들어오면 해당 위치에는 값이 없으므로 패스
    if(N > arr.size) println(-1) else println(arr[N-1])
}
