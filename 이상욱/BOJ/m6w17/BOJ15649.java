package m6w17;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15649 {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i + 1;
		}
		int[] out = new int[n];
		boolean[] isUsed = new boolean[n];

		perm(arr, out, isUsed, 0, n, m);

		System.out.println(sb.toString());
	}

	private static void perm(int[] arr, int[] out, boolean[] isUsed, int depth, int n, int m) {

		if (depth == m) {
			for (int i = 0; i < m; i++) {
				sb.append(out[i] + " ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 0; i < n; i++) {
			if (!isUsed[i]) {
				isUsed[i] = true;
				out[depth] = arr[i];
				perm(arr, out, isUsed, depth + 1, n, m);
				isUsed[i] = false;
			}
		}

	}
}
