import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.collections.ArrayList

lateinit var parent:Array<Int>
fun main() {
    var br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())

    var N = st.nextToken().toInt()
    var M = st.nextToken().toInt()

    parent = Array(N+1){0}
    for(i in 0..N){
        parent[i] = i
    }

    var sb = StringBuffer()
    for(i in 1..M){
        st = StringTokenizer(br.readLine())
        var isCalculate = st.nextToken().toInt()
        var x = st.nextToken().toInt()
        var y = st.nextToken().toInt()

        //같은 집합에 포함되어 있는가?
        if(isCalculate == 1){
            var ans = if(isSame(x,y)) "YES" else "NO"
            sb.append("$ans\n")
        }
        //합집합 수행
        else{
            union(x,y)
        }
    }
    println(sb)
}

fun isSame(x:Int, y:Int):Boolean{
    var x = find(x)
    var y = find(y)

    return x==y
}

fun union(x:Int, y:Int){
    var x = find(x)
    var y = find(y)

    if(x != y){
        if(x<y){
            parent[y] = x
        }else{
            parent[x] =y
        }
    }
}

fun find(x:Int):Int{
    if(x == parent[x]){
        return x
    }
    //부모에 넣어주기
    parent[x] = find(parent[x])
    return parent[x]
}