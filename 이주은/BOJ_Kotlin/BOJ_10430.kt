import java.util.*

fun main(){
    val br = System.`in`.bufferedReader()
    val st = StringTokenizer(br.readLine())

    var a = st.nextToken().toInt()
    var b = st.nextToken().toInt()
    var c = st.nextToken().toInt()

    println((a + b) % c)
    println(((a % c) + (b % c)) % c)
    println((a * b) % c)
    println(((a % c) * (b % c)) % c)
}