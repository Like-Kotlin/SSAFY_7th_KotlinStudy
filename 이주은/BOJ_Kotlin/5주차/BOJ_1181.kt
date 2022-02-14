import java.io.BufferedReader
import java.io.InputStreamReader

fun main()=with(BufferedReader(InputStreamReader(System.`in`))){
    var n = readLine().toInt()
    val arr: MutableSet<String> = mutableSetOf()

    for (i in 0 until n){
        arr.add(readLine())
    }

    val list = arr.sortedWith(kotlin.Comparator<String> { o1, o2 ->
            if(o1.length == o2.length)
                o1.compareTo(o2)
            else
                o1.length - o2.length
        })

    for(i in list){
        println(i)
    }
}