package step

private val selfNum = Array<Boolean>(10001, {false})

fun main() {
    for(i in 1..10000){
        d(i.toString())
    }
    val sb = StringBuilder()
    for (i in 1 until selfNum.size){
        if(!selfNum[i]) sb.append("$i\n")
    }
    print(sb)
}

fun d(num : String){
    var n = num.toInt()
    var arr = num.toCharArray()
    for(i in 0 until arr.size){
        n += Integer.parseInt(arr[i].toString())
    }
    if(n < 10001) selfNum[n] = true
}