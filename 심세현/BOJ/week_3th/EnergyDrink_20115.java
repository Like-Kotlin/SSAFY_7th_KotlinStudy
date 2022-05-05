package beckjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class EnergyDrink_20115 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] Drink = new int[N];
        for(int i=0; i<N; i++){
            Drink[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(Drink);

        double total = Drink[N-1];
        for(int i=0; i<N-1; i++){
            total += (double)Drink[i] / 2;
        }
        System.out.println(total);
    }
}
