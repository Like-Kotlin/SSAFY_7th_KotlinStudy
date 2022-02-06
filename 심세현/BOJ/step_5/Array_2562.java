
package beckjoon.array;

import java.util.Scanner;

public class Array_2562 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[9];

        for(int i=0; i<arr.length; i++){
            arr[i] = sc.nextInt();
        }
        sc.close();

        int max = 0;
        int number = 0;

        for(int i=0; i<arr.length; i++){
            if(arr[i] > max){
                max = arr[i];
                number = i+1;
            }
        }
        System.out.printf("%d\n", max);
        System.out.printf("%d\n", number);
    }

}

