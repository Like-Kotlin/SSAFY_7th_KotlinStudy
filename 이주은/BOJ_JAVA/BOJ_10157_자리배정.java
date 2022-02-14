import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10157_자리배정 {
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static int c, r;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		c = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());

		int target = Integer.parseInt(br.readLine());

		if(c * r < target){
			System.out.println(0);
			return;
		}

		int[][] map = new int[c][r];
		int x, y;
		int newX = 0, newY = 0, num = 0, dir = 0;

		while(true){
			num++;
			x = newX;
			y = newY;

			if(num == target){
				System.out.println((x + 1) + " " + (y + 1));
				break;
			}

			map[x][y] = num;

			newX = x + dx[dir];
			newY = y + dy[dir];

			if(isWall(newX, newY) || map[newX][newY] != 0){
				dir = (dir + 1) % 4;
				newX = x + dx[dir];
				newY = y + dy[dir];
			}
		}


	}

	static boolean isWall(int x, int y){
		if(x < 0 || x >= c || y < 0 || y >= r){
			return true;
		}
		return false;
	}
}
