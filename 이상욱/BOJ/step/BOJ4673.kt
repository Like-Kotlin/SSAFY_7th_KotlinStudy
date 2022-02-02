package level6

val arr = IntArray(10001)

fun main(){

    for(i in 1..10000){
        d(i)
    }

    for( i in 1..10000){
        if(arr[i] == 0){
            println(i)
        }

    }

}

fun d(n : Int){

    var num = n

    val s = n.toString()

    for(i in s.indices){
        num += s[i] - '0'
    }

    if(num <= 10000){
        arr[num] = 1
    }

}