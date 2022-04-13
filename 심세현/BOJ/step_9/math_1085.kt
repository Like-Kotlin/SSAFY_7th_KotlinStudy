import java.util.*

private val br = System.`in`.bufferedReader()

fun main() {
    var st = StringTokenizer(br.readLine())
    var curX = st.nextToken().toInt()
    var curY = st.nextToken().toInt()
    var x = st.nextToken().toInt()
    var y = st.nextToken().toInt()

    var min = Math.min(curX, curY)
    min = Math.min(x - curX, min)
    min = Math.min(y - curY, min)
    println(min)
}