import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

var n = 0
var max = Integer.MIN_VALUE
var min = Integer.MAX_VALUE
var nums = mutableListOf<Int>()
var oper = mutableListOf<Int>()

fun main()=with(BufferedReader(InputStreamReader(System.`in`))){
    n = readLine().toInt()
    var st = StringTokenizer(readLine())

    for(i in 0 until n){
        nums.add(i, st.nextToken().toInt())
    }

    st = StringTokenizer(readLine())

    for(i in 0 until 4){
        oper.add(st.nextToken().toInt())
    }

    calc(nums[0], 1)

    println(max)
    println(min)
}

fun calc(number: Int, idx: Int): Unit{
    if(idx == n){
        max = Math.max(number, max)
        min = Math.min(number, min)
    }

    for(i in 0 until 4){
        if(oper[i] > 0){
            oper[i]--

            when(i){
                0 -> calc(number + nums[idx], idx + 1)
                1 -> calc(number - nums[idx], idx + 1)
                2 -> calc(number * nums[idx], idx + 1)
                3 -> calc(number / nums[idx], idx + 1)
            }

            oper[i]++
        }
    }
}
