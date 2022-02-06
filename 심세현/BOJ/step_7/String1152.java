
package beckjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class String1152 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        String[] arr = new String[1000000];
        int cnt = 0;

        for(int i=0; i<arr.length; i++){
                if(st.hasMoreTokens()){
                    String str = st.nextToken();
                    arr[i] = str;
                } else {
                    break;
                }
        }
        for(int i=0; i<arr.length; i++){
            if(arr[i] != null){
                cnt++;
            }else{
                break;
            }
        }
        System.out.println(cnt);

    }
}

