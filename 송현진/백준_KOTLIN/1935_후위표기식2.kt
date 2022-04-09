import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

lateinit var input:String
lateinit var arr:Array<Double>

fun main() {
    var br = BufferedReader(InputStreamReader(System.`in`))
    var N = br.readLine().toInt()

    input = br.readLine()
    arr = Array(27){0.0}

    for(i in 0 until N){
        var value = br.readLine().toDouble()
        arr[i] = value
    }

    var result = calculate()
    println(String.format("%.2f",result))
}

fun calculate(): Double {
    var numStack = Stack<Double>()

    //input으로 받은 String 다 돌기
    for (i in input.indices) {
        var ch = input[i]

        //받은 글자가
        if (ch in 'A'..'Z') {
            var res = ch - 'A'
            numStack.push(arr[res])
        }
        else {

            //2개뽑아서 위치 바꾸기
            //먼저 pop된 숫자가 뒤로 가야한다.
            var val2 = numStack.pop()
            var val1 = numStack.pop()

            when (ch) {
                '+' -> {
                    var plus = val1 + val2
                    numStack.push(plus)
                }
                '-' -> {
                    var minus = val1 - val2
                    numStack.push(minus)
                }
                '*' -> {
                    var mul = val1 * val2
                    numStack.push(mul)
                }
                else -> {
                    var div = val1 / val2
                    numStack.push(div)
                }
            }
        }
    }

    return numStack.pop()
}