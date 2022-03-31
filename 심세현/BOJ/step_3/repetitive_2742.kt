package step

private val br = System.`in`.bufferedReader()

fun main() {
    val A : Int = Integer.parseInt(br.readLine())
    var sb = StringBuilder()
    for(i in A downTo 1){
        sb.append("${i} \n")
    }
    print(sb)
}