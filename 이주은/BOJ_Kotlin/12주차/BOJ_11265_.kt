package `12주차`

import java.io.BufferedReader
import java.io.InputStreamReader

fun main()=with(BufferedReader(InputStreamReader(System.`in`))){

    val arg = readLine().split(" ")
    val partyPlace = Array<Array<Int>>(arg[0].toInt() + 1, {Array<Int>(arg[0].toInt() + 1, {0})})
    for(i in 1 .. arg[0].toInt()){
        var tmp = readLine().split(" ")
        for(j in 1 .. arg[0].toInt()){
            partyPlace[i][j] = tmp[j - 1].toInt()
        }
    }

    for(k in 1 .. arg[0].toInt()){
        for(i in 1 .. arg[0].toInt()){
            for(j in 1 .. arg[0].toInt()){
                if(partyPlace[i][j] > partyPlace[i][k] + partyPlace[k][j])
                    partyPlace[i][j] = partyPlace[i][k] + partyPlace[k][j]
            }
        }
    }

    for(i in 0 until arg[1].toInt()){
        var tmp = readLine().split(" ");

        if(partyPlace[tmp[0].toInt()][tmp[1].toInt()] <= tmp[2].toInt())
            println("Enjoy other party")
        else
            println("Stay here")
    }

}