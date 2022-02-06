package level17

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

class Bridge{

    fun combination(n : Double, r : Double) : Double{

        var a = 1.0
        var b = 1.0

        for(i in n.toInt() downTo (n-r).toInt()+1){
            a *= i
        }

        for(i in 2 .. r.toInt()){
            b *= i
        }

        return a/b
    }

}

fun main(){

    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())

    val n = st.nextToken().toInt()

    repeat(n){
        st = StringTokenizer(br.readLine())

        val a  = st.nextToken().toInt()
        val b = st.nextToken().toInt()

        val bridge = Bridge()

        print("%.0f".format(bridge.combination(b.toDouble(),a.toDouble())))
        println()
    }

}