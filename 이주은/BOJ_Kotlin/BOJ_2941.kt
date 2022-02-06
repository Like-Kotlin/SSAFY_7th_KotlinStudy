import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    var s = readLine()
    var alphaArray = arrayOf("c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=")

    for(i in 0 until alphaArray.size){
        s = s.replace(alphaArray.get(i), "2")
    }

    println(s.length)

}