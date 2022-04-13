package step

import java.util.*

private val br = System.`in`.bufferedReader()

fun main() {
    val st = StringTokenizer(br.readLine())
    var fir : Int = Integer.parseInt(st.nextToken())
    val sec : Int = Integer.parseInt(st.nextToken())
    val thr : Int = Integer.parseInt(st.nextToken())
    var result : Int = 0
    // 같은 눈이 3개인 경우
    if(fir == sec && sec == thr){
        result = 10000.plus(fir * 1000)
    } // 같은 눈이 2개인 경우
    else if(fir == sec || fir == thr){
        result = 1000.plus(fir * 100)
    }
    else if(sec == thr){
        result = 1000.plus(sec * 100)
    }// 모두 다른 눈인 경우
    else {
        if(fir >= sec && fir >= thr){
            result = (fir * 100)
        }
        else if(sec >= fir && sec >= thr){
            result = (sec * 100)
        }
        else if(thr >= fir && thr >= sec){
            result = (thr * 100)
        }
    }
    println(result)
}