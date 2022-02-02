package level4

import java.io.*
import java.util.*


//A+B 4
fun main(){

    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    var st : StringTokenizer

    while(true){

        val input = br.readLine() ?: break

        st = StringTokenizer(input)
        val A = st.nextToken().toInt()
        val B = st.nextToken().toInt()

        bw.write("${A+B}\n")
        bw.flush()

    }

}