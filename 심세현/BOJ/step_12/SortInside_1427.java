package beckjoon.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class SortInside_1427 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        Integer[] arr = new Integer[s.length()];
        for(int i=0; i<s.length(); i++){
            arr[i] = Integer.parseInt(String.valueOf(s.charAt(i)));
        }
        Arrays.sort(arr, Collections.reverseOrder());
        for(int i : arr){ System.out.print(i); }
    }
}
