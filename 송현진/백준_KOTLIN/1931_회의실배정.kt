import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*


fun main() {
    var br = BufferedReader(InputStreamReader(System.`in`))
    var N = br.readLine().toInt()

    var nodes = mutableListOf<Node>()
    for(i in 0 until N){
        var st = StringTokenizer(br.readLine())
        var start = st.nextToken().toInt()
        var end = st.nextToken().toInt()

        nodes.add(Node(start,end))
    }

    //그냥 정렬하면 에러 발생 ->Node클래스 내에서 정렬 기준 설정하기
    nodes.sort()

    var cnt = 0
    var prevEnd = 0
    for(i in 0 until N){
        //현재 노드 추출
        var curNode = nodes[i]
        //이전 끝난 시각 <= 현재 노드의 시작 시간
        if(prevEnd <= curNode.start){
            //이전 끝 시각 = 현재 끝 시각
            prevEnd = curNode.end
            cnt++
        }
    }
    println(cnt)
}

//data클래스로 생성 , Comparable구현
data class Node(var start:Int, var end:Int): Comparable<Node>{

    override fun compareTo(other: Node): Int {
        //끝이 같을 경우 현재 시작 - 이전 시작 기준 정렬
        //끝이 다를 경우 현재 끝 - 이전 끝 기준 정렬
        return if(this.end==other.end)  this.start-other.start else this.end-other.end
    }
}
