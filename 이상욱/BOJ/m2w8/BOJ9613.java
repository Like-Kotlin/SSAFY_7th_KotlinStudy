package m2w8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ9613 {
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; i++) {
			
			st = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(st.nextToken());
			
			int[] arr = new int[n];
			
			for(int j = 0; j < n; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			
			Long sum = 0L;
			
			for(int j = 0; j < n; j++) {
				for(int k = j+1; k < n; k++) {
					sum += getGCD(arr[j],arr[k]);
				}
			}
			
			System.out.println(sum);
			
		}
		
	}
	
	public static int getGCD(int num1, int num2) {
		
		if(num1 < num2) {
			if(num1 == 0) {
				return num2;
			}else {
				return getGCD(num1, num2 % num1);
			}
		}else {
			if(num2 == 0) {
				return num1;
			}else {
				return getGCD(num2, num1 % num2);
			}
		}
	}
}
