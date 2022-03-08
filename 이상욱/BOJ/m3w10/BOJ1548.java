package m2w10;

import java.io.*;
import java.util.*;

public class BOJ1548{
    public static void main(String[] args) throws Exception{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        
        st = new StringTokenizer(br.readLine());
        
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        if(arr.length <= 2){
            System.out.println(arr.length);
            return;
        }
        
        Arrays.sort(arr);
        
        int max = -1;
        for(int i = 0; i < n-2; i++){
            for(int j = n-1; j > i+1; j--){
                if(arr[i] + arr[i+1] > arr[j]){
                    max = Math.max(max,j-i+1);
                }
            }
        }
        
        if(max == -1){
            max = 2;
        }
        
        System.out.println(max);
    }
}