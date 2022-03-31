package step

private val br = System.`in`.bufferedReader()

fun main() {
    var list = arrayListOf<Int>()

    for(i in 0 until 10){
        var x = Integer.parseInt(br.readLine()) % 42
        if(!list.contains(x)) list.add(x)
    }
    println(list.size)
}