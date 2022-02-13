import java.util.*

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)

    var input:String = readLine().toString()
    val index = 0;
    var result = mutableListOf<Int>()
    for(i in 0..25){
        result.add(-1)
    }
    for(i in 0.. input.length -1){
        if(result[input[i].code - 97] == -1){
            result[input[i].code - 97] = i
        }
    }

    for(i in result.indices){
        print(result[i].toString() + " ")
    }
}
