import java.util.*
import java.io.*

var N = 0
var isItFirst = 0
var dx = arrayOf(1,0,-1,0)
var dy = arrayOf(0,1,0,-1)
lateinit var arr: Array<Array<Int>>
lateinit var resultArr: Array<Array<Int>>

fun main(){
    var br = BufferedReader(InputStreamReader(System.`in`))
    N = br.readLine().toInt()
    arr = Array(N*N+1){Array(4){0}}
    resultArr = Array(N){Array(N){0}}

    for(i in 0 until N * N){
        var st = StringTokenizer(br.readLine()," ")
        var studentNum = st.nextToken().toInt()
        for(j in 0..3){
            arr[studentNum][j] = st.nextToken().toInt()
        }

        findSeat(studentNum)
    }

    calculateSatisfaction()
}

fun findSeat(num: Int){

    if(isItFirst == 0){
        //첫 학생은 1,1 자리에 위치
        resultArr[1][1] = num
        isItFirst++
    }
    else{
        //각자리 위부터 돌면서 좋아하는 애가 제일 많은 자리를 픽스
        var mostX = 0
        var mostY = 0
        var maxCnt = -1 //주변이 0일경우 고려
        var studentMaxZeroCnt = -1 //주변이 0일경우 고려

        //가장 자리 빈곳 많은 곳 찾기
        var zeroMostX = 0
        var zeroMostY = 0
        var maxZeroCnt = -1 // 주변이 0일경우 고려

        for(i in resultArr.indices){
            for(j in resultArr.indices){
                //결과배열이 0으로 아직 자리가 있으면 좋아하는 학생 4명있는지 상하좌우 탐색
                if(resultArr[i][j] == 0){

                    var studentCnt = 0 //해당 자리의 학생 수 위한 변수
                    var zeroCnt = 0 // 해당 자리 주변 빈곳 찾기위한 변수

                    for(k in 0 until 4){//좋아하는 학생만큼 돌기
                        for(m in 0 until 4){//상하좌우
                            var nx = i + dx[m]
                            var ny = j + dy[m]
                            //범위 체크
                            if(nx<0 || nx >= N || ny < 0 || ny >= N)
                                continue

                            if(arr[num][k] == resultArr[nx][ny]){
                                studentCnt++
                            }
                            if(resultArr[nx][ny] == 0){
                                zeroCnt++
                            }
                        }
                    }
                    //그 자리가 가장 친구수 많은 자리면 해당 좌표값 저장
                    if(maxCnt < studentCnt){
                        mostX = i
                        mostY = j
                        maxCnt = studentCnt
                        studentMaxZeroCnt = zeroCnt
                    }
                    //친구수는 같은데 주변 빈곳이 더 많다면 i,j 갱신
                    else if(maxCnt == studentCnt && studentMaxZeroCnt < zeroCnt){
                        mostX = i
                        mostY = j
                        maxCnt = studentCnt
                        studentMaxZeroCnt = zeroCnt
                    }

                    //가장 주변 많이 빈곳 찾기 위한 용도
                    if(maxZeroCnt < zeroCnt){
                        zeroMostX = i
                        zeroMostY = j
                        maxZeroCnt = zeroCnt
                    }
                }
            }
        }

        //좋아하는 애 있으면 해당 자리에 넣어주기
        if(maxCnt > 0){
            resultArr[mostX][mostY] = num
        }
        //좋아하는 애 없으면 조건 따져서 빈곳 많은곳 중 가장 작은칸애 배치
        else if(maxCnt == 0){
            resultArr[zeroMostX][zeroMostY] = num
        }
    }
}

fun calculateSatisfaction(){
    var totalSatisfaction = 0

    for(i in resultArr.indices){
        for(j in resultArr.indices){

            var studentCnt = 0
            //주변 살피면서 좋아하는애 몇명인지 확인하기
            for(m in 0..3){
                for(k in 0..3){
                    var nx = i+dx[k]
                    var ny = j+dy[k]
                    if(nx<0 || nx>= N || ny<0 || ny>= N)
                        continue
                    var curStudent = resultArr[i][j]
                    if(arr[curStudent][m] == resultArr[nx][ny]){
                        studentCnt++
                    }
                }
            }

            when(studentCnt){
                1 -> totalSatisfaction += 1
                2 -> totalSatisfaction += 10
                3 -> totalSatisfaction += 100
                4 -> totalSatisfaction += 1000
            }
        }
    }
    println(totalSatisfaction)
}
