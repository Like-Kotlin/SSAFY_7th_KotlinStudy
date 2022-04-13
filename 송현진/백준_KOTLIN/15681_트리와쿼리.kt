import java.io.*
import java.util.*


var N = 0
var R = 0
var Q = 0
lateinit var arr:Array<ArrayList<Int>>
lateinit var visit:Array<Boolean>
lateinit var dp:Array<Int>
fun main() {
    var br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())

    N = st.nextToken().toInt()
    R = st.nextToken().toInt()
    Q = st.nextToken().toInt()

    arr = Array(N+1){ArrayList<Int>()}
    visit = Array(N+1){false}
    dp = Array(N+1){0}

    repeat(N-1){
        st = StringTokenizer(br.readLine())
        var u = st.nextToken().toInt()
        var v = st.nextToken().toInt()

        arr[u].add(v)
        arr[v].add(u)
    }

    dfs(R)//dfs를 통한 dp 수행 -> 루트 부터 시작

    var sb = StringBuffer()
    repeat(Q){
        var input = br.readLine().toInt()
        sb.append("${dp[input]}\n")
    }

    println(sb)
}

fun dfs(cur: Int):Int{
    //이미 dp에 값이 들어있다면 해당 트리는 계산 끝 -> return 해당 계산 값
    if(dp[cur] != 0){
        return dp[cur]
    }

    visit[cur] = true // 방문 표시
    var cnt = 1 // 자신 포함하여 개수 세기
    for(node in arr[cur]){ //arr[cur]내의 연결된 노드 불러오기
        if(visit[node]){//노드 방문했던 곳이면 패스
            continue
        }
        cnt += dfs(node)//dfs돎면서 노드 연결된 곳 개수 세기
    }
    dp[cur] = cnt//해당 개수 저장
    return dp[cur]//반환
}
