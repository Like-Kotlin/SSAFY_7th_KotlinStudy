import java.util.*

var result:Int = 0

fun combi(n:Int){
    if(n == 0){
        result++
        return
    }
    if(n < 0 ) return

    for(i in 1..3){
        combi(n-i)
    }
}


fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)

    val T = sc.nextInt()
    for(case in 1..T){
        val n = sc.nextInt()
        result = 0
        combi(n)
        println(result)
    }

}

