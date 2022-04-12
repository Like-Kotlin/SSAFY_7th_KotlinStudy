import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*


lateinit var parent: Array<Int>
lateinit var visit:Array<Boolean>
var N = 0
var root = 0
var cnt = 0
fun main() {
    var br = BufferedReader(InputStreamReader(System.`in`))
    N = br.readLine().toInt()

    parent = Array(N){0}
    visit = Array(N){false}

    var st = StringTokenizer(br.readLine())
    for(i in 0 until N){
        parent[i] = st.nextToken().toInt()
        if(parent[i] == -1) root=i
    }

    var delete = br.readLine().toInt()
    deleteNode(delete)

    calculate(root)

    println(cnt)
}

fun deleteNode(delete: Int){
    //현재 노드 삭제
    parent[delete] = -2

    for(i in 0 until N){//연결된 하위노드 찾아서
        if(parent[i]==delete){
            deleteNode(i)//타고 들어가서 삭제
        }
    }
}

fun calculate(r: Int){
    var isLeaf = true//리프노드 true로 설정
    visit[r] = true//방문체크

    if(parent[r] != -2){//삭제된 노드가 아니면 진행
        for(i in 0 until N){//n-1까지 돌면서
            if(!visit[i] && parent[i]==r){//아직 방문 안했고 부모가 현재 노드면
                calculate(i)//타고 들어가기
                isLeaf = false//타고들어갈 수 있으므로 leaf는 아님
            }
        }
        if(isLeaf) cnt++ //타고들어간게 없어서 리프가 맞다면 cnt++
    }
}