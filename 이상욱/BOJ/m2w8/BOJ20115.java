package m2w8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ20115 {
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		Double[] arr = new Double[n];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < n; i++) {
			arr[i] = Double.parseDouble(st.nextToken());
		}
		
		Arrays.sort(arr,Collections.reverseOrder());
		
		double sum = arr[0];
		
		for(int i = 1; i < n; i++) {
			if(sum+arr[i]/2 > sum/2 + arr[i]) {
				sum = sum + arr[i]/2;
			}else {
				sum = sum/2 + arr[i];
			}
		}
		
		System.out.println(sum);
		
	}
}
