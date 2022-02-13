package beckjoon.sort;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// Arrays.sort() 는 내부적으로 퀵정렬함 최악의 경우 O(n^2), 평균적으로 가장 빠름
// Collections.sort() 는 내부적으로 합병정렬 + 삽입정렬을 섞은 하이브리드 정렬, 최악의 경우 더 빠름
public class NumSort2_2751 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        int n = sc.nextInt();
        for(int i=0; i<n; i++){
            list.add(sc.nextInt());
        }
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for(int i : list){ sb.append(i+"\n"); }
        System.out.print(sb);
    }
}
