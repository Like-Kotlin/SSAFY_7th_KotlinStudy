package m2w7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ1874 {
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] input = new int[n];
		
		for(int i = 0; i < n; i++) {
			
			input[i] = Integer.parseInt(br.readLine());
			
		}
		
		int num = 1;
		int idx = 0;
		Stack<Integer> stk = new Stack<>();
		
		StringBuilder sb = new StringBuilder();
		
		while(idx < n) {
			
			if(num > n) {
				System.out.println("NO");
				return;
			}
			
			stk.push(num);
			sb.append("+\n");
			
			while(!stk.isEmpty() && stk.peek() == input[idx]) {
				
				stk.pop();
				sb.append("-\n");
				idx++;
			}
			
			num++;
		}
		
		System.out.println(sb.toString());
		
	}
}
