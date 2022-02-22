import java.util.*
import java.io.*
fun main(){
    var br = BufferedReader(InputStreamReader(System.`in`))
    var tc = br.readLine().toInt()

    var arr = Array(12){0}
    arr[1] = 1//1
    arr[2] = 2// 1+1 2
    arr[3] = 4// 1+1+1 1+2 2+1 3

    for(i in 4..11){
        arr[i] = arr[i-3] + arr[i-2] + arr[i-1]
    }

    for(i in 1..tc){
        println(arr[br.readLine().toInt()])
    }
}
