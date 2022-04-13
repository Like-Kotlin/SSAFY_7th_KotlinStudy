
import java.util.*

private val br = System.`in`.bufferedReader()

fun main() {
    val st = StringTokenizer(br.readLine())
    val N = st.nextToken().toInt()
    val K = st.nextToken().toInt()

    val q = arrayListOf<String>()
    for(i in 1..N){  q.add("$i")  }

    val arr = Array<Boolean>(N+1, {false})
    var cnt = 1

    var sb = StringBuilder()
    sb.append("<")
    while(!q.isEmpty()){
        var flag = false

        for(i in 1..N){
            if(cnt % K == 0){
                if(!arr[i]){
                    sb.append("$i").append(",").append(" ")
                    arr[i] = true
                    cnt++
                }
            }
            if(!arr[i]) {
                cnt++
                flag =true
            }
        }
        if(!flag) break
    }
    sb.deleteCharAt(sb.lastIndexOf(","))
    println(sb.substring(0, sb.length-1)+">")
}