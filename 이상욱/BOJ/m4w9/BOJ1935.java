package m4w9;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BOJ1935 {
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		String question = br.readLine();
		ArrayList<String> list = new ArrayList<String>();
		
		for(int i = 0; i < n; i++) {
			String num = br.readLine();
			list.add(num);
		}
		
		Queue<String> queue = new LinkedList<>();
		
		for(int i = 0; i < question.length(); i++) {
			
			char q = question.charAt(i);
			
			if(q != '+' && q != '-' && q != '*' && q != '/') {
				
				queue.offer(list.get(q - 'A'));
				
			}else {
				queue.offer(String.valueOf(q));
			}
		}
		
		Stack<String> stk = new Stack<>();
		
		while(!queue.isEmpty()) {
			
			String poll = queue.poll();
			
			if(!poll.equals("+")  && !poll.equals("-") && !poll.equals("*") && !poll.equals("/")){
	            stk.push(poll);
	        }else {
	        	
	        	double num1 = Double.parseDouble(stk.pop());
	        	double num2 = Double.parseDouble(stk.pop());
	        	
	        	double res = calc(num1,num2,poll);
	        	
	        	stk.push(String.valueOf(res));
	        	
	        }
			
		}
		
		double answer = Double.parseDouble(stk.pop());
		
		System.out.println(String.format("%.2f", answer));
	}

	private static double calc(double num1, double num2, String poll) {
		
		switch(poll) {
		case "+": return num2 + num1;
		case "-": return num2 - num1;
		case "*": return num2 * num1;
		case "/": return num2 / num1;
		}
		
		return 0;
	}
}
