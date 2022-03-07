import java.util.*


fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)

    val N = sc.nextInt()
    var input = mutableListOf<Int>()

    var max:Int = 0

    for(i in 1..N){
        val temp = sc.nextInt()
        input.add(temp)
        if(input.last() > input[max]){
            max = i - 1
        }
    }

    var result:Double = input[max].toDouble()
    for(i in 0..N-1){
        if(i != max)
            result += input[i].toDouble() / 2
    }
    println(result)
}

