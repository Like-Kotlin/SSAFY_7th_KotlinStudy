import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

val br = BufferedReader(InputStreamReader(System.`in`))
fun main(){

    val n = br.readLine().toInt()
    val stk = Stack<Int>()

    repeat(n){

        val str = br.readLine()

        when (str.split(" ")[0]) {
            "push" -> stk.push(str.split(" ")[1].toInt())

            "pop" -> if (stk.isNotEmpty()) {
                val pop = stk.pop()
                println(pop)
            } else {
                println(-1)
            }

            "size" -> println(stk.size)
            "top" -> if (stk.isNotEmpty()) {
                println(stk.peek())
            } else {
                println(-1)
            }
            "empty" ->  if (stk.isEmpty()) {
                println(1)
            } else {
                println(0)
            }

        }




    }

}