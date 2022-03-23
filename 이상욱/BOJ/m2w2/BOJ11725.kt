package m2w7

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*


fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))
    var st : StringTokenizer

    val N = br.readLine().toInt()

    val arr = Array<ArrayList<Int>>(N+1){ arrayListOf()}

    repeat(N-1){

        st = StringTokenizer(br.readLine())

        val first = st.nextToken().toInt()
        val second = st.nextToken().toInt()

        arr[first].add(second)
        arr[second].add(first)

    }

    val visit = BooleanArray(N+1)
    val result = IntArray(N+1)

    val q = LinkedList<Int>()

    q.offer(1)
    visit[1] = true

    while (q.isNotEmpty()){

        val num = q.poll()

        arr[num].forEach {
            if(!visit[it]){
                visit[it] = true
                result[it] = num
                q.add(it)
            }
        }

    }

    for (i in 2 until arr.size){

        println(result[i])

    }


}

