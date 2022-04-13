package step

private val br = System.`in`.bufferedReader()
private var cnt = 0

fun main() {
    val x = br.readLine().toInt()
    for(i in 1..x){
        getCnt(i)
    }
    print(cnt)
}
// 한수 구하기
fun getCnt(x : Int){
    if(x < 100){ cnt++ }
    else
    {
        var arr = x.toString().toCharArray()
        var dis = arr[0] - arr[1]
        for(i in 1 until arr.size - 1){
            var newDis = arr[i].toString().toInt() - arr[i+1].toString().toInt()
            if(dis != newDis) return
        }
        cnt++
    }
}