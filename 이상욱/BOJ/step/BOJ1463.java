package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ1463 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int target = Integer.parseInt(br.readLine());

		int[] memo = new int[target + 1];
		Arrays.fill(memo, Integer.MAX_VALUE);
		memo[0] = 0;
		memo[1] = 0;

		for (int i = 2; i < memo.length; i++) {

			if (i % 3 == 0) {
				memo[i] = Math.min(memo[i], memo[i / 3] + 1);
			}

			if (i % 2 == 0) {
				memo[i] = Math.min(memo[i], memo[i / 2] + 1);
			}

			memo[i] = Math.min(memo[i], memo[i - 1] + 1);

		}
		System.out.println(memo[target]);
	}
}
