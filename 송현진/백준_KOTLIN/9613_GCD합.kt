import java.util.*;
import java.io.*;
import kotlin.collections.ArrayList

fun main(){
    var br = BufferedReader(InputStreamReader(System.`in`))
    var round = br.readLine().toInt()

    for(i in 1..round) {
        var st = StringTokenizer(br.readLine(), " ")
        var N = st.nextToken().toInt()

        var inputArr = Array(N) { 0 }
        for (j in 0 until N) {
            inputArr[j] = st.nextToken().toInt()
        }

        if(inputArr.size == 1) {
            println(inputArr[0])
            continue
        }

        var pairArr = ArrayList<Pair<Int, Int>>()
        for (j in 0 until N-1) {
            for (k in j + 1 until N) {
                var pair = Pair(inputArr[j], inputArr[k])
                pairArr.add(pair)
            }
        }

        var result = findResult(pairArr)
        println(result)
    }
}

fun findResult(arr: ArrayList<Pair<Int, Int>>):Long {
    var ans:Long = 0
    for(i in 0 until arr.size){
        ans += gcd(arr[i].first, arr[i].second)
    }
    return ans;
}

fun gcd(first: Int, second: Int): Long{
    return if(second == 0) first.toLong()
    else gcd(second, first % second)
}