import java.util.*

fun main(){
    val br = System.`in`.bufferedReader()
    val st = StringTokenizer(br.readLine())

    var h = st.nextToken().toInt()
    var m = st.nextToken().toInt() - 45

    if(m < 0){
        m += 60
        h -= 1
    }

    if(h < 0){
        h += 24
    }
    var answer = h.toString() + " " + m.toString()
    println(answer)
}