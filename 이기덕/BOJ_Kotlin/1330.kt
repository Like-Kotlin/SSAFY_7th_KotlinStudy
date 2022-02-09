import java.util.*

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)

    var a = sc.next().toInt()
    var b = sc.next().toInt()

    if(a > b){
        println(">")
    }else if(a < b){
        println("<")
    }else{
        println("==")
    }
}

