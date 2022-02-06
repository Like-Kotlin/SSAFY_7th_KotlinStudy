
package beckjoon.array;

import java.util.*;

public class Array_1546 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        float[] subject = new float[sc.nextInt()];
        float max = 0;

        for(int i=0; i<subject.length; i++){
            subject[i] = sc.nextFloat();
            if(subject[i] > max){
                max = subject[i];
            }
        }
        sc.close();

        float[] score = new float[subject.length];
        float total = 0;

        for(int i=0; i<score.length; i++){
            score[i] = (subject[i] / max) * 100;
            total += score[i];
        }

        float avg = total / subject.length;
        System.out.println(avg);
    }
}
