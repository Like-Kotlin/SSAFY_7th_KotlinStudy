import java.util.*
import java.io.*

var N = 0
var M = 0
var cntOfVisible = 0
var cntOfInvisible = 0

lateinit  var house: Array<IntArray>
lateinit var visited: Array<BooleanArray>
lateinit var invisibleVisited: Array<BooleanArray>

var even_dx = arrayOf(-1,-1,0,0,1,1)
var even_dy = arrayOf(-1,0,-1,1,-1,0)
var odd_dx = arrayOf(-1,-1,0,0,1,1)
var odd_dy = arrayOf(0,1,-1,1,0,1)

class Node constructor (x: Int, y:Int){
    var x:Int = x
    var y:Int = y
}

fun main(){
    var br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())

    M = st.nextToken().toInt()
    N = st.nextToken().toInt()
    house = Array(N+1){IntArray(M+1){0}}
    visited = Array(N+1){BooleanArray(M+1) }
    invisibleVisited = Array(N+1){BooleanArray(M+1) }

    for(i in 1 .. N){
        st = StringTokenizer(br.readLine())
        for(j in 1..M){
            house[i][j] = st.nextToken().toInt()
        }
    }

    for(i in 1..N) {
        for (j in 1..M) {
            //보이는 부분 bfs
            if(!visited[i][j] && house[i][j]==1){
                bfs(i,j)
            }
            //안보이는 부분 bfs
            if(!invisibleVisited[i][j] && house[i][j] == 0){
                cntOfInvisible = 0//초기화
                invisibleBFS(i,j)
            }
        }
    }
    println(cntOfVisible)
}

fun invisibleBFS(i: Int, j: Int){
    var isItWall = false
    var q:Queue<Node> = LinkedList()

    q.offer(Node(i,j))
    invisibleVisited[i][j] = true

    while(!q.isEmpty()){
        var tmp:Node = q.poll()

        //벽만나면 invisibleCnt 0으로 만들고 리턴
        if(tmp.x==1 || tmp.x==N || tmp.y==M || tmp.y== 1){
            isItWall = true
        }

        if(tmp.x % 2 == 0){
            //invisible이면 false
            checkAroundEven(tmp.x,tmp.y,1)
        }else {
            checkAroundOdd(tmp.x,tmp.y,1)
        }

        //홀수 줄은 odd_dx
        //짝수 줄은 even_dx
        for(k in 0..5){
            var nx: Int
            var ny: Int
            //짝수면
            if(tmp.x % 2 == 0){
                nx = tmp.x + even_dx[k]
                ny = tmp.y + even_dy[k]
            }else{
                nx = tmp.x + odd_dx[k]
                ny = tmp.y + odd_dy[k]
            }

            if(nx < 1 || nx > N || ny < 1 || ny>M) continue
            if(invisibleVisited[nx][ny] || house[nx][ny]==1) continue
            q.add(Node(nx,ny))
            invisibleVisited[nx][ny] = true
        }
    }
    //벽을 만났으면 카운트 하던 것 0으로 바꿈
    if(isItWall) cntOfInvisible = 0
    //계산
    cntOfVisible -= cntOfInvisible
}

//visible인 곳 찾기
fun bfs(i: Int, j: Int){
    var q:Queue<Node> = LinkedList()
    q.offer(Node(i,j))
    visited[i][j] = true

    while(!q.isEmpty()){
        var tmp:Node = q.poll()

        if(tmp.x % 2 == 0){
            checkAroundEven(tmp.x,tmp.y, 0)
        }else {
            checkAroundOdd(tmp.x,tmp.y, 0)
        }

        for(k in 0..5){
            var nx = if(tmp.x % 2 == 0) tmp.x + even_dx[k] else tmp.x + odd_dx[k]
            var ny = if(tmp.x % 2 == 0) tmp.y + even_dy[k] else tmp.y + odd_dy[k]

            if(nx < 1 || nx > N || ny < 1 || ny>M) continue
            if(visited[nx][ny] || house[nx][ny]==0) continue
            q.add(Node(nx,ny))
            visited[nx][ny] = true
        }
    }
}

//isitvisible == 0 -> visible ㅇㅇ
fun checkAroundEven(i:Int, j:Int,isItVisible: Int){
    //좌상단이 범위 안넘어가고 집이면
    for(k in 0..5){
        if(isItVisible == 0){
            if(isWall(i+even_dx[k],j+even_dy[k]) || house[i+even_dx[k]][j+even_dy[k]]==0){
                cntOfVisible++
            }
        }
        if(isItVisible == 1){
            if(!isWall(i+even_dx[k],j+even_dy[k]) && house[i+even_dx[k]][j+even_dy[k]]==1){
                cntOfInvisible++
            }
        }
    }
}

fun checkAroundOdd(i:Int, j:Int, isItVisible: Int){
    //좌상단이 범위 안넘어가고 집이면
    for(k in 0..5){
        if(isItVisible == 0){
            if(isWall(i+odd_dx[k],j+odd_dy[k]) || house[i+odd_dx[k]][j+odd_dy[k]]==0){
                cntOfVisible++
            }
        }
        if(isItVisible == 1){
            if(!isWall(i+odd_dx[k],j+odd_dy[k]) && house[i+odd_dx[k]][j+odd_dy[k]]==1){
                cntOfInvisible++
            }
        }
    }
}

fun isWall(i: Int, j: Int):Boolean{
    //벽일때
    if(i < 1 || i>N || j < 1 || j>M) return true
    //벽이 아닐때
    return false
}