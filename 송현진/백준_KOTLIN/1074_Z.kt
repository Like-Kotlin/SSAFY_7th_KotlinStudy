import java.io.*
import java.util.*
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

var cnt = 0
fun main(){
    var br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine()," ")
    var N = st.nextToken().toDouble()
    var r = st.nextToken().toInt()
    var c = st.nextToken().toInt()

    findResult( Math.pow(2.0,N).toInt(),r,c)
    println(cnt)
}

fun findResult(N:Int, r:Int, c:Int) {
    if(N==1){
        return
    }

    //1사분면에 있을 경우
    if(r<N/2 && c < N/2){
        findResult(N/2,r,c)
    }
    //2사분면에 있을 경우
    else if(N/2 in (r + 1)..c){
        cnt += (N * N)/4 //한개의 사분면 크기만 더함
        findResult(N/2,r,c-N/2) //이전 사분면으로 이동
    }
    //3사분면에 있을경우
    else if(N/2 in (c + 1)..r){
        cnt += (N*N)/4*2 // 2개 사분면크기 더함
        findResult(N/2,r-N/2,c) //이동
    }
    //4사분면에 있을 경우
    else{
        cnt += (N*N)/4*3
        findResult(N/2,r-N/2,c-N/2)
    }
}