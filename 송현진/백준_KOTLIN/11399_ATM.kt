
import java.util.*
import java.io.*

fun main() {
    var br = BufferedReader(InputStreamReader(System.`in`))
    var N = br.readLine().toInt()

    var st = StringTokenizer(br.readLine()," ")
    var arr = Array<Int>(N){0}

    for(i in 0 until N){
        arr[i] = st.nextToken().toInt()
    }

    Arrays.sort(arr)

    var result = arr[0]

    var newArr = Array<Int>(N){0}
    newArr[0] = arr[0]
    for(i in 1 until N){
        newArr[i] = newArr[i-1] + arr[i]
        result += newArr[i]
    }

    println(result)
}