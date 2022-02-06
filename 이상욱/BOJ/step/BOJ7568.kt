package level11

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

data class Person(

    val height : Int,
    val weight : Int,
    var order : Int = 1

)

fun main(){

    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())

    val n = st.nextToken().toInt()

    val personArr = Array(n){Person(0,0)}

    for(i in 0 until n){

        st = StringTokenizer(br.readLine())

        personArr[i] = Person((st.nextToken().toInt()),st.nextToken().toInt())

    }

    for (i in personArr.indices){
        for(j in personArr.indices){

            if(i != j){

                if(personArr[i].height < personArr[j].height &&
                    personArr[i].weight < personArr[j].weight){
                    personArr[i].order++
                }

            }

        }
    }

    for(i in personArr.indices){

        print("${personArr[i].order} ")

    }

}