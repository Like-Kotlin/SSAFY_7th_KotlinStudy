import java.util.*

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    val T = sc.nextInt();

    var input:Int
    var min = 10000001
    var max = -10000001



    for(i in 1..T){
        input = sc.nextInt()
        if(input > max) max = input
        if(input < min) min = input
    }

    println(min.toString() + " " + max)

}
