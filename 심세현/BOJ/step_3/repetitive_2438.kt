package step

private val br = System.`in`.bufferedReader()

fun main() {
    val A : Int = Integer.parseInt(br.readLine())
    var sb = StringBuilder()

    for(i in 1..A){
        for(j in 1..i){
            sb.append("*")
        }
        sb.append("\n")
    }
    print(sb)
}