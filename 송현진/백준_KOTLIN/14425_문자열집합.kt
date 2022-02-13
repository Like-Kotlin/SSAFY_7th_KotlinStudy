import java.io.*
import java.util.*

fun main(){
    var br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine()," ")
    var N = st.nextToken().toInt()
    var M = st.nextToken().toInt()

    var hs = HashSet<String>()
    for(i in 1..N){
        hs.add(br.readLine())
    }

    var cnt = 0;
    for(i in 1..M){
        cnt += check(br.readLine(),hs)
    }

    println(cnt)
}
fun check(input: String, hs: HashSet<String>) = when{
    hs.contains(input) -> 1
    else -> 0
}