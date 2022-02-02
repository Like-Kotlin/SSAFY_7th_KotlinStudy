package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ10828 {
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		Stack<Integer> stk = new Stack<>();
		
		for(int i = 0; i < n; i++) {
			
			String str = br.readLine();
			
			switch(str.split(" ")[0]) {
			
			case "push":
				stk.push(Integer.parseInt(str.split(" ")[1]));
				break;
				
			case "pop":
				if(!stk.isEmpty()) {
					int pop = stk.pop();
					System.out.println(pop);
				}else {
					System.out.println(-1);
				}
				break;
			case "size" :
				System.out.println(stk.size());
				break;
			
			case "top" :
				if(!stk.isEmpty()) {
					System.out.println(stk.peek());
				}else {
					System.out.println(-1);
				}
				break;
			case "empty":
				if(!stk.isEmpty()) {
					System.out.println(1);
				}else {
					System.out.println(0);
				}
				break;
			}
			
		}
	}
}
