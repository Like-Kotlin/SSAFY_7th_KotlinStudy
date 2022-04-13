import java.util.*

private val br = System.`in`.bufferedReader()

fun main() {
    var listX = arrayListOf<Int>()
    var listY = arrayListOf<Int>()
    for(i in 0..2){
        var st = StringTokenizer(br.readLine())
        var x = st.nextToken().toInt()
        var y = st.nextToken().toInt()

        if(listX.contains(x)){  listX.remove(x)  }
        else listX.add(x)

        if(listY.contains(y)){  listY.remove(y)  }
        else listY.add(y)
    }
    println("${listX.get(0)} ${listY.get(0)}")
}