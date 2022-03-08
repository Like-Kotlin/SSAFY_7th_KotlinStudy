import java.util.*
import java.io.*
import kotlin.math.abs

var N = 0
var L = 0
var R = 0
var isItMove = false
lateinit var arr:Array<Array<Int>>
lateinit var visited:Array<Array<Int>>
lateinit var hs:HashSet<Node>
var dx = arrayOf(1,0,-1,0)
var dy = arrayOf(0,1,0,-1)

fun main() {
    var br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())

    N = st.nextToken().toInt()
    L = st.nextToken().toInt()
    R = st.nextToken().toInt()

    arr = Array(N){Array(N){0}}
    for(i in 0 until N){
        st = StringTokenizer(br.readLine()," ")
        for(j in 0 until N){
            arr[i][j] = st.nextToken().toInt()
        }
    }

    var moveCnt = 0
    while(true){

        isItMove = false //인구이동이 일어났는지 확인용
        visited = Array(N){Array(N){0}}

        //한판 이동
        for(i in 0 until N){
            for(j in 0 until N){
                //아직 방문 안했으면 돌기
                //0 방문x , 1 방문ㅇㅇ값변경은x, 2방문ㅇㅇ값변경ㅇㅇ
                if(visited[i][j]==0){
                    bfs(i,j)
                }
            }
        }

        if(!isItMove){
            break
        }else{
            moveCnt++
        }
    }
    println(moveCnt)
}

class Node constructor (x: Int, y:Int){
    var x:Int = x
    var y:Int = y
}

fun bfs(i: Int, j: Int){
    var sum = arr[i][j] //현재 자리 포함해야 하므로 현재 자리값으로 초기화
    var cnt = 1 //현재자리 포함해야 하므로 1
    var q:Queue<Node> = LinkedList()
    hs = HashSet<Node>()//변경할 위치만 저장한 hashSet

    q.offer(Node(i,j))
    visited[i][j] = 1

    while(!q.isEmpty()){
        var tmp = q.poll()
        hs.add(tmp) // 변경할 노드 저장

        for(k in 0..3){
            var nx = tmp.x + dx[k]
            var ny = tmp.y + dy[k]

            if(nx<0 || ny <0 || nx >=N || ny>=N) continue
            if(visited[nx][ny] != 0) continue

            //현재 자리와 사방면값 차이가 L과 R사이 값인지 확인
            var dif = abs(arr[tmp.x][tmp.y]-arr[nx][ny])
            if(dif in L..R){
                cnt++
                sum += arr[nx][ny]

                q.offer(Node(nx,ny))
                visited[nx][ny] = 1
                isItMove = true // 인구이동 한번이라도 일어날 시 true로 변경
            }
        }
    }

    //다 돌고난 후 평균 값 계산
    var average = sum / cnt
    calculate(average)
}
fun calculate(avg: Int){
    //평균 값으로 visited 1 인곳 값을 변경하고 변경한 곳은 2로 변경
    //필요한 자리만 hashSet으로 가져와서 변경
    //전체자리 하나씩 탐색하면 시간초과!!
    for(i in hs){
        if(visited[i.x][i.y]==1){
            arr[i.x][i.y] = avg
            visited[i.x][i.y] = 2
        }
    }
}