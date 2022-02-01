fun main(){
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    var n = br.readLine().toInt()

    for(i in 1 .. n){
        for(j in n downTo 1){
            bw.write(
                if(i >= j) "*"
                else    " "
            )
        }
        bw.write("\n")
    }

    bw.flush()
}