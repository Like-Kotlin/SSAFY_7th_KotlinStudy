
private val br = System.`in`.bufferedReader()

fun main() {
    val r = br.readLine().toInt()
    val fir = r*r*Math.PI
    val sec = 2*r*r
    println(fir)
    println(sec.toDouble())
}