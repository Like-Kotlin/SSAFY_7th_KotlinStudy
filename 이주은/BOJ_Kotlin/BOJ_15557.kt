import java.util.*

fun main(){
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    var st: StringTokenizer
    var n = br.readLine().toInt()

    for(i in 0 until n){
        st = StringTokenizer(br.readLine())
        var a = st.nextToken().toInt()
        var b = st.nextToken().toInt()
        var sum = a + b

        bw.write("" + sum + "\n")
    }
    bw.flush()
}