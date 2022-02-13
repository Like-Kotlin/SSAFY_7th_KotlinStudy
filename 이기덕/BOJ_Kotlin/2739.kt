import java.util.*

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    var T = sc.next().toInt()

    var input:Int
    var input2:Int
    for(i in 1..T){
        input = sc.nextInt()
        input2 = sc.nextInt()
        println(input+input2)
    }
}

