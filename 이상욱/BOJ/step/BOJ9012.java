package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ9012 {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			String vps = br.readLine();
			String answer = check(vps);
			System.out.println(answer);
		}
	}

	private static String check(String vps) {

		Stack<Character> stk = new Stack<>();

		for (int i = 0; i < vps.length(); i++) {

			if (stk.isEmpty()) {
				stk.add(vps.charAt(i));
			} else {

				char c = stk.peek();

				if (c == '(' && vps.charAt(i) == ')') {
					stk.pop();

				} else {
					stk.add(vps.charAt(i));
				}

			}

		}

		if (stk.isEmpty()) {
			return "YES";
		}

		else {
			return "NO";
		}

	}
}
