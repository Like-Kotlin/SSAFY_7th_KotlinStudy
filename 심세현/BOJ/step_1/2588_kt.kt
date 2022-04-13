package step

private val br = System.`in`.bufferedReader()

fun main() {
    val A : Int = Integer.parseInt(br.readLine())
    val B : String = br.readLine()

    val list = B.toCharArray()

    var first : Int =  A * Integer.parseInt(list[2].toString())
    val second : Int = A * Integer.parseInt(list[1].toString())
    val third : Int = A * Integer.parseInt(list[0].toString())
    val result : Int = A * Integer.parseInt(B)

    println(first)
    println(second)
    println(third)
    println(result)
}