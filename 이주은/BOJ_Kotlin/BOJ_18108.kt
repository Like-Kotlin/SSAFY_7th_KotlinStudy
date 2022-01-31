import java.util.*

/*fun main(){
    val y = System.`in`.bufferedReader()
    val st = StringTokenizer(y.readLine())
    var answer = st.nextToken().toInt();
    answer -= 543
    println(answer)
}*/

fun main(args: Array<String>) = println(
    readLine()!!
        .toInt()
        .let { it - 543}
)