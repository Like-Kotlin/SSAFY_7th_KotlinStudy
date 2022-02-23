import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*


class Edge(var a: Int, var b :Int){
    fun contain(input: Int) :Boolean{
        if(a == input || b == input){
            return true
        }
        return false
    }
    fun another(input: Int) :Int{
        if(input == a)
            return b;
        return a;
    }
}
fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    var array = mutableListOf<Edge>()
    var result = mutableListOf<Int>()
    val N = br.readLine().toInt()

    repeat(N-1){
        val token = StringTokenizer(br.readLine())
        val t = token.nextToken().toInt()
        val t2 = token.nextToken().toInt()
        array.add(Edge(t, t2))
        result.add(0);
    }
    result.add(0);
    result.add(0);

    var stack = Stack<Int>();
    stack.push(1)

    while(array.size > 0){
        val curr = stack.peek()
        stack.pop()
        var temp = mutableListOf<Edge>();
        for(j in array.iterator()){
            if(j.contain(curr)){
                val target = j.another(curr)
                stack.push(target)
                result[target] = curr
            }else{
                temp.add(j)
            }
        }
        array = temp
    }
    for(i in 2..N){
        bw.write(result[i].toString() + "\n")
    }
    bw.flush()
    bw.close()
}

