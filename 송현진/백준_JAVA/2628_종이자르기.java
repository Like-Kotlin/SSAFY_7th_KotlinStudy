import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int cnt = Integer.parseInt(br.readLine());
        int[] wArr = new int[w];
        int[] hArr = new int[h];

        int wcnt = 0;
        int hcnt = 0;
        for(int i = 0; i<cnt; i++){
            st = new StringTokenizer(br.readLine()," ");
            int check = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            if(check == 0){
                hArr[num]++;
                hcnt++;
            }
            else{
                wArr[num]++;
                wcnt++;
            }
        }  
        int wmax = size(wArr,wcnt,w);
        int hmax = size(hArr,hcnt,h);

        System.out.println(hmax*wmax);
    }
    public static int size(int[] arr, int cnt, int size){
        int start = 0;
        int max = cnt == 0? size:0;
        for(int i = 0; i<size; i++){
            if(arr[i] == 1){
                if(i-start > max){
                    max = i-start;
                }
                start = i;
            }
        }
        if(size - start > max){
            max = size-start;
        }
        return max;
    }
}