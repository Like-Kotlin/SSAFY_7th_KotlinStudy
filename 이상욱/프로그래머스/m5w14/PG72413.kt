package m5w14

class Solution3 {
    lateinit var map : Array<IntArray>
    fun solution(n: Int, s: Int, a: Int, b: Int, fares: Array<IntArray>): Int {
        var answer: Int = 0

        map = Array(n){IntArray(n){25000000}}

        repeat(n){ i ->
            map[i][i] = 0

        }

        fares.forEach{
            map[it[0]-1][it[1]-1] = it[2]
            map[it[1]-1][it[0]-1] = it[2]

        }

        floyd(n)

        answer = map[s-1][a-1] + map[s-1][b-1]

        repeat(n){ i ->
            answer = Math.min(answer,map[s-1][i] + map[i][a-1] + map[i][b-1])
        }


        return answer
    }

    fun floyd(n : Int){

        repeat(n){ k ->
            repeat(n){ i ->
                repeat(n){ j ->

                    map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j])

                }
            }
        }

    }
}