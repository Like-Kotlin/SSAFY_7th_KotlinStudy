fun main(){
    var arr = findSelfNumber()

    for(i in 0..arr.size-1){
        if(arr[i] == 1){
            println(i)
        }
    }
}

fun findSelfNumber(): Array<Int> {
    var arr = Array(10001,{0})

    for(i in 1 until arr.size){
        var start = i
        arr[start]++

        while(true){
            var originalInt = start
            var originalString = start.toString()

            for(element in originalString){
                originalInt += element -'0'
            }

            if(originalInt > 10000) break;

            arr[originalInt]++
            start = originalInt
        }
    }

    return arr
}

