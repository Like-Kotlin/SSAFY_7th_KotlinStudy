package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11047 {
public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int num = Integer.parseInt(st.nextToken());
		int money = Integer.parseInt(st.nextToken());
		
		int[] coin = new int[num];
		
		for (int i = 1; i < num+1; i++) {
			st = new StringTokenizer(br.readLine());
			coin[num-i] = Integer.parseInt(st.nextToken());
			
		}
		
		int cnt = 0;
		
		while(money!= 0) {
			
			for (int i = 0; i < coin.length; i++) {
				if(money >= coin[i]) {
					cnt+= money/coin[i];
						money%=coin[i];
				}
				
			}
			
		}
		System.out.println(cnt);
}	
	
	
}
