
package beckjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class String1157 {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String input = br.readLine().toUpperCase();
            int[] arr = new int[26];

            for(int i=0; i<input.length(); i++){
                arr[(int)input.charAt(i) - 65]++;
            }
            int max = -1;
            char ch = '?';

            for(int i=0; i<arr.length; i++){
                if(max < arr[i]){
                    max = arr[i];
                    ch = (char)(i+65);
                }else if(max == arr[i]){
                    ch = '?';
                }
            }
            System.out.println(ch);
    }
}
