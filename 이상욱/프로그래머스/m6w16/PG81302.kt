package m6w16

class PG81302 {

    val dx = intArrayOf(1,0,-1,0)
    val dy = intArrayOf(0,1,0,-1)

    fun solution(places: Array<Array<String>>): IntArray {
        var answer = IntArray(5)

        for(i in places.indices){

            answer[i] = if(check(places[i])){
                1
            }else{
                0
            }


        }


        return answer
    }

    private fun check(map : Array<String>) : Boolean{

        if(firstCheck(map) && secondCheck(map)){
            return true
        }
        return false

    }

    private fun firstCheck(map : Array<String>) : Boolean{

        for(i in map.indices){
            for(j in map.indices){
                if(map[i][j] == 'P'){

                    for(k in 0 until 4){
                        val nx = i+dx[k]
                        val ny = j+dy[k]

                        if(nx in 0 until 5 && ny in 0 until 5 && map[nx][ny] == 'P' ){
                            return false
                        }
                    }
                }
            }
        }
        return true
    }

    private fun secondCheck(map : Array<String>) : Boolean{
        for(i in map.indices){
            for(j in map.indices){
                if(map[i][j] == 'O'){
                    var cnt = 0
                    for(k in 0 until 4){
                        val nx = i+dx[k]
                        val ny = j+dy[k]

                        if(nx in 0 until 5 && ny in 0 until 5 && map[nx][ny] == 'P' ){
                            cnt++
                        }
                    }
                    if(cnt >= 2){
                        return false
                    }
                }
            }
        }
        return true

    }

}