import java.io.*

fun main(){
    var br = BufferedReader(InputStreamReader(System.`in`))
    var A = br.readLine()
    var B = br.readLine()

    var arr = Array(A.length+1){Array(B.length+1){0}}
    //lcs 참고 블로그 : https://velog.io/@emplam27/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EA%B7%B8%EB%A6%BC%EC%9C%BC%EB%A1%9C-%EC%95%8C%EC%95%84%EB%B3%B4%EB%8A%94-LCS-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-Longest-Common-Substring%EC%99%80-Longest-Common-Subsequence
    for(i in 1..A.length){
        for(j in 1..B.length){
            if(A[i-1] == B[j-1]){
                arr[i][j] = arr[i - 1][j - 1] + 1
            }
            else {
                arr[i][j] = Math.max(arr[i][j-1], arr[i-1][j])
            }
        }
    }
    println(arr[A.length][B.length])
}