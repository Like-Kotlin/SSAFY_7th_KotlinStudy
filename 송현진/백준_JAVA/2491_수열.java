import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        
        int[] arr = new int[N];
        for(int i = 0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = findMax(arr);
        int min = findMin(arr);
        int result = Math.max(max, min);

        System.out.println(result);

    }
    public static int findMax(int[] arr){
        int max = 1;
        int cnt = 1;
        for(int i = 0; i<arr.length-1; i++){

            if(arr[i]<=arr[i+1]){
                cnt++;
            }else{
                max = Math.max(max,cnt);
                cnt = 1;
            }
            max = Math.max(max,cnt);
        }
        return max;
    }

    public static int findMin(int[] arr){
        int min = 1;
        int cnt = 1;
        for(int i = 0; i<arr.length-1; i++){// 1 1 ->len = 2
            if(arr[i]>=arr[i+1]){
                cnt++;
            }else{
                min = Math.max(min,cnt);
                cnt = 1;
            }
            min = Math.max(min,cnt);
        }
        return min;
    }
}