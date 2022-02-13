import java.util.*

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)

    var input:Int
    var index:Int = 1
    var max = -1



    for(i in 1..9){
        input = sc.nextInt()
        if(input > max) {
            max = input
            index = i
        }
    }

    println(max)
    println(index)
}
