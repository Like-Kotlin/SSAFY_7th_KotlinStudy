import java.io.*
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){

    while(true){
        val line = readLine()
        if(line == null)
            break;
        else{
            val st = StringTokenizer(line)
            val a = st.nextToken().toInt()
            val b = st.nextToken().toInt()
            println(a + b)
        }
    }
}