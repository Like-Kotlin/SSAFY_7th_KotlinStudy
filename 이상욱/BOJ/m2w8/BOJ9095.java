package m2w8;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ9095 {

	static int[] ans = new int[11];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int testNum = Integer.parseInt(br.readLine());

		ans[0] = 0;
		ans[1] = 1;
		ans[2] = 2;
		ans[3] = 4;

		for (int i = 4; i < ans.length; i++) {
			ans[i] = ans[i - 3] + ans[i - 2] + ans[i - 1];
		}

		for (int i = 0; i < testNum; i++) {

			int num = Integer.parseInt(br.readLine());

			System.out.println(ans[num]);

		}
	}
}
