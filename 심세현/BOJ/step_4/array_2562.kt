private val br = System.`in`.bufferedReader()

fun main() {
    var arr = Array<Int>(9, {0})

    var max = 0
    var idx = 0
    for(i in 0..8){
        arr[i] = Integer.parseInt(br.readLine())
        if(arr[i] > max){
            max = arr[i]
            idx = i+1
        }
    }
    println(max)
    println(idx)


}