import java.util.*

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)

    var N = sc.next().toInt()
    var arrays = mutableListOf<Int>();
    for(i in 0 .. N - 1){
        var input = sc.next().toInt()
        arrays.add(input)
    }
    var curr = 0;
    var stack = Stack<Int>();
    var result = mutableListOf<Char>();

    for(i in 1 .. N){
        stack.push(i)
        result.add('+')
        while(!stack.empty() && stack.peek() == arrays[curr]){
            result.add('-')
            stack.pop()
            curr++
            if(curr == N) break
        }
        if(curr == N) break
    }
    if(curr == N){
        for(i in result.indices){
            println(result[i])
        }
    }else{
        println("NO")
    }

}

