package `15주차`

import java.io.BufferedReader
import java.io.InputStreamReader

fun main()=with(BufferedReader(InputStreamReader(System.`in`))){
    val input = readLine()
    var minA = 0
    var minB = 0
    var max = 0
    var X = -1L
    var A = -1
    var B = -1

    for(ch in input){
        if(ch.isDigit()){
            max = max.coerceAtLeast(Character.getNumericValue(ch))
        } else
            max = max.coerceAtLeast(ch - 'a' + 10)

        if(ch == ' '){
            minA = max + 1
            max = 0
        }
    }

    minB = max + 1

    val (a, b) = input.split(' ')

    for(i in minA .. 36){
        var x = 0L
        for(ch in a){
            if(ch.isDigit())
                x = x * i + Character.getNumericValue(ch)
            else
                x = x * i + (ch - 'a' + 10)
        }

        if(x < 0L)
            break

        label@for(j in minB .. 36){
            if(i == j)
                continue
            var y = 0L

            for(ch in b){
                if(ch.isDigit())
                    y = y * j + Character.getNumericValue(ch)
                else
                    y = y * j + (ch - 'a' + 10)

                if(y > x)
                    break@label
            }

            if(x == y){
                if(X != -1L) {
                    println("Multiple")
                    return
                }

                X = x
                A = i
                B = j
            }
        }
    }

    if(X == -1L){
        println("Impossible")
    }
    else
        println("$X $A $B")
}