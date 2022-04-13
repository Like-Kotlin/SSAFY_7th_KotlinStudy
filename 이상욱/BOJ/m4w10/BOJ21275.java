package m4w10;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ21275 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		String char1 = st.nextToken();
		String char2 = st.nextToken();

		long x = -1L;
		int a = -1;
		int b = -1;

		for (int i = 2; i <= 36; i++) {

			long changeA = change(i, char1);

			if (changeA == -1L) {
				continue;
			}

			for (int j = 2; j <= 36; j++) {
				if (i == j) {
					continue;
				}
				long changeB = change(j, char2);
				if (changeB == -1L) {
					continue;
				}

				if (changeA == changeB) {
					if (x == -1L) {
						x = changeA;
						a = i;
						b = j;
					} else {
						System.out.println("Multiple");
						return;
					}
				}

			}

		}

		if (x == -1L) {
			System.out.println("Impossible");
		} else {
			System.out.println(x + " " + a + " " + b);
		}

	}

	private static long change(int num, String ch) {

		long result = 0L;
		long mul = 1L;

		for (int i = ch.length() - 1; i >= 0; i--) {
			if (changeLong(ch.charAt(i)) + 1 > num) {
				return -1L;
			}

			result += changeLong(ch.charAt(i)) * mul;
			mul *= num;

			if (result < 0) {
				return -1L;
			}
		}

		return result;
	}

	private static long changeLong(char ch) {

		long res = 0L;
		
		if (ch >= '0' && ch <= '9') {
			res = ch - '0';
		} else {
			res = ch - 'a' + 10;
		}

		return res;
	}
}
