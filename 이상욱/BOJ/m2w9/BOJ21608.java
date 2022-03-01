package m2w9;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ21608 {

	static int[][] like;
	static int[][] map;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int n;
	static int answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		
		n = Integer.parseInt(br.readLine());
		map = new int[n + 1][n + 1];
		like = new int[n * n][5];

		for (int i = 0; i < n * n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				like[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < like.length; i++) {
			find(like[i]);
		}

		Arrays.sort(like, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0]) {
					return o1[1] - o2[1];
				}else {
					return o1[0] - o2[0];
				}
				
			}
		});

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				int stu = map[i][j];
				int[] arr = like[stu - 1];
				int cnt = 0;
				for (int k = 0; k < 4; k++) {
					int nx = i + dx[k];
					int ny = j + dy[k];
					if (nx >= 1 && nx <= n && ny >= 1 && ny <= n) {
						for (int a = 0; a < arr.length; a++) {
							if (arr[a] == map[nx][ny]) {
								cnt++;
								break;

							}
						}
					}
				}

				switch (cnt) {
				case 0:
					answer += 0;
					break;
				case 1:
					answer += 1;
					break;
				case 2:
					answer += 10;
					break;
				case 3:
					answer += 100;
					break;
				case 4:
					answer += 1000;
					break;
				}

			}
		}
		System.out.println(answer);
	}

	private static void find(int[] arr) {
		int stu = arr[0];
		ArrayList<int[]> list = new ArrayList<>();

		int max = 0;

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (map[i][j] == 0) {
					int cnt = 0;
					for (int k = 0; k < 4; k++) {
						int nx = i + dx[k];
						int ny = j + dy[k];

						if (nx >= 1 && nx <= n && ny >= 1 && ny <= n) {
							for (int a = 0; a < arr.length; a++) {
								if (arr[a] == map[nx][ny]) {
									cnt++;
									break;

								}
							}
						}
					}
					if (max < cnt) {
						max = cnt;
						list.clear();
						list.add(new int[] { i, j });
					} else if (max == cnt) {
						list.add(new int[] { i, j });
					}
				}
			}
		}

		if (list.size() == 1) {
			int row = list.get(0)[0];
			int col = list.get(0)[1];
			map[row][col] = stu;
			return;
		}

		int cntBlank = 0;
		int maxBlank = 0;
		ArrayList<int[]> blankList = new ArrayList<int[]>();

		for (int i = 0; i < list.size(); i++) {
			int[] pair = list.get(i);

			int x = pair[0];
			int y = pair[1];

			for (int j = 0; j < 4; j++) {
				int nx = x + dx[j];
				int ny = y + dy[j];

				if (nx >= 1 && nx <= n && ny >= 1 && ny <= n) {
					if (map[nx][ny] == 0) {
						cntBlank++;
					}
				}
			}

			if (cntBlank > maxBlank) {
				blankList.clear();
				blankList.add(new int[] { x, y });
				maxBlank = cntBlank;
			} else if (cntBlank == maxBlank) {
				blankList.add(new int[] { x, y });
			}

			cntBlank = 0;

		}

		
		Collections.sort(blankList, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {

				if (o1[0] < o2[0]) {
					return -1;
				} else if (o1[0] == o2[0]) {
					if (o1[1] < o2[1]) {
						return -1;
					}
				}

				return 0;
			}
		});
		
		int row = blankList.get(0)[0];
		int col = blankList.get(0)[1];
		map[row][col] = stu;
	}
}
