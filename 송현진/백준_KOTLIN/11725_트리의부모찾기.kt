import java.io.*
import java.util.*
import kotlin.collections.ArrayList

fun main() {
    var br = BufferedReader(InputStreamReader(System.`in`))
    var N = br.readLine().toInt()

    var arr = Array(N+1){ArrayList<Int>()}
    for(i in 0 until N-1){
        var st = StringTokenizer(br.readLine()," ")
        var first = st.nextToken().toInt()
        var second = st.nextToken().toInt()

        arr[first].add(second)
        arr[second].add(first)
    }

    var ans = bfs(arr,N)

    for(i in 2..N){
        println(ans[i])
    }
}

fun bfs(arr: Array<ArrayList<Int>>, N: Int):Array<Int>{
    var ans = Array(N+1){0}
    var queue:Queue<Int> = LinkedList();

    queue.offer(1)
    ans[1]=1
    while(!queue.isEmpty()){
        var tmp = queue.poll()

        for(i in 0 until arr[tmp].size){
            var cur = arr[tmp].get(i)
            if(ans[cur] == 0) {
                ans[cur] = tmp
                queue.offer(cur)
            }
        }
    }
    return ans
}


