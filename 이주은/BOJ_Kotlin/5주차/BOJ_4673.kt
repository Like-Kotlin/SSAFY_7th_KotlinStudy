fun main(){
    var arr = BooleanArray(10001)

    for(i in 1 until 10001){
        var n = d(i)

        if(n <= 10000)
            arr[n] = true
    }

    for(i in 1 until 10001){
        if(!arr[i])
            println(i)
    }

}

fun d(i: Int): Int{
    var result = i
    var div = i

    while(div != 0){
        result += (div % 10)
        div /= 10
    }

    return result
}