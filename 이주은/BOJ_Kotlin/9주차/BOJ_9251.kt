import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

fun main()=with(BufferedReader(InputStreamReader(System.`in`))){
    val arr1 = readLine().toCharArray();
    val arr2 = readLine().toCharArray();
    val map = Array(arr1.size + 1, { Array(arr2.size + 1, { 0 }) });

    for(i in 1..arr1.size){
        for(j in 1..arr2.size){
            if(arr1[i - 1] == arr2[j - 1])
                map[i][j] = map[i - 1][j - 1] + 1;
            else
                map[i][j] = max(map[i][j - 1], map[i - 1][j]);
        }
    }

    println(map[arr1.size][arr2.size]);
}