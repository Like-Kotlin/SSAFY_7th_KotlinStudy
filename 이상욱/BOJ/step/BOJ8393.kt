package level3


//합
fun main(){
    val n = readLine()!!.toInt()

    var sum = 0
    for(i in 1..n){
        sum+=i
    }
    println(sum)
}