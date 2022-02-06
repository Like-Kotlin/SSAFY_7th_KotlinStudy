import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.util.*

fun main()=with(BufferedReader(InputStreamReader(System.`in`))){
    var t = readLine().toInt()
    while(t --> 0){
        var order = readLine().toCharArray()
        var n = readLine().toInt()
        var s = readLine()
        s = s.substring(1, s.length - 1)
        var arr = s.split(",")

        var deque = ArrayDeque<String>()
        for(i in 0 until n){
            deque.add(arr[i])
        }

        var error = false
        var reverse = false

        for(i in 0 until order.size){
            if(order[i] == 'R')
                reverse = !reverse
            else{
                if(n - 1 < 0){
                    error = true
                    break
                }

                if(reverse){
                    deque.pollLast()
                } else
                    deque.pollFirst()

                n--
            }
        }

        var sb = StringBuilder()

        if(error)
            sb.append("error\n")
        else{
            sb.append("[")

            for(i in 0 until n){
                if(reverse)
                    sb.append(deque.pollLast())
                else
                    sb.append(deque.poll())

                if(i != n - 1){
                    sb.append(",")
                }
            }

            sb.append("]\n")
        }
        print(sb)
    }

}