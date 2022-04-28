package m4w12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ14502 {
	static int col, row;
	static int[][] map;
	static int[][] copy;
	static ArrayList<int[]> virus = new ArrayList<int[]>();
	static int max;
	static int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());

		map = new int[row][col];
		copy = new int[row][col];

		for (int i = 0; i < row; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < col; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					virus.add(new int[] { i, j });
				}
			}

		}
		max = 0;
		setWall(0, 0);
		System.out.println(max);

	}

	static void setWall(int start, int depth) {

		if (depth == 3) {
			copymap();

			for (int i = 0; i < virus.size(); i++) {
				dfs(virus.get(i)[0], virus.get(i)[1]);
			}

			int num = safe();

			if (num > max)
				max = num;

			return;

		}

		for (int i = start; i < row * col; i++) {
			int x = i / col;
			int y = i % col;

			if (map[x][y] == 0) {
				map[x][y] = 1;
				setWall(i + 1, depth + 1);
				map[x][y] = 0;
			}
		}
	}

	static int safe() {

		int cnt = 0;

		for (int i = 0; i < copy.length; i++) {
			for (int j = 0; j < copy[0].length; j++) {
				if (copy[i][j] == 0)
					cnt++;
			}

		}

		return cnt;
	}

	static void dfs(int x, int y) {

		for (int i = 0; i < dir.length; i++) {
			int newX = x + dir[i][0];
			int newY = y + dir[i][1];

			if (newX >= 0 && newX < row && newY >= 0 && newY < col && copy[newX][newY] == 0) {
				copy[newX][newY] = 2;
				dfs(newX, newY);

			}

		}

	}

	static void copymap() {

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				copy[i][j] = map[i][j];
			}

		}
	}
}
