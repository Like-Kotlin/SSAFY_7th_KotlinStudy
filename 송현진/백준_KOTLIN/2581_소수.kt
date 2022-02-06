import java.io.*
import kotlin.math.PI
import kotlin.math.round

fun main(){
    var br = BufferedReader(InputStreamReader(System.`in`))
    var N = br.readLine().toInt()
    var M = br.readLine().toInt()

    findResult(N,M)
}

fun findResult(N: Int, M: Int){
    var min = 0
    var firstMin = 0

    for(i in N..M){
        var isItTrue = true
        
        for(j in 2 until i){
            if(i % j == 0){
                isItTrue = false
                break
            }
        }
        //합 계산
        if(isItTrue){
            if(i == 1){
                continue
            }
            if(firstMin == 0){
                firstMin = i
            }
            min +=i
        }
    }

    if(firstMin != 0){
        println(min)
        println(firstMin)
    }else{
        print(-1)
    }
}


