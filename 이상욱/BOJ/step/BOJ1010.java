package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Bridge {

	public double combination(double n, double r) {
		double a = 1, b = 1;
		for (double i = n; i > (n - r); i--) {
			a *= i;

		}
		for (double i = 2; i <= r; i++) {
			b *= i;
		}

		return a / b;

	}
}

public class BOJ1010 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			double a = Integer.parseInt(st.nextToken());
			double b = Integer.parseInt(st.nextToken());
			Bridge brid = new Bridge();

			System.out.printf("%.0f", brid.combination(b, a));
			System.out.println();

		}
	}
}
