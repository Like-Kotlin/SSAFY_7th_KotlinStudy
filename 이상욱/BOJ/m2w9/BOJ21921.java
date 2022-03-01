package m2w9;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ21921 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		long sum = 0L;
		
		for(int i = 0; i < x; i++) {
			sum+=arr[i];
		}
		int cnt = 1;
		long max = sum;
		
		for(int i = x; i < n; i++) {
			sum+=arr[i];
			sum-=arr[i-x];
			
			if(sum > max) {
				max = sum;
				cnt = 1;
			}else if(sum == max) {
				cnt++;
			}
		}
		
		if(max == 0L) {
			System.out.println("SAD");
		}else {
			System.out.println(max);
			System.out.println(cnt);
		}
		
	}
}
