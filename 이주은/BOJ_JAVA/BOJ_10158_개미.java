import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10158_개미 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] st = br.readLine().split(" ");

		int w = Integer.parseInt(st[0]);
		int h = Integer.parseInt(st[1]);

		st = br.readLine().split(" ");
		int x = Integer.parseInt(st[0]);
		int y = Integer.parseInt(st[1]);

		int t = Integer.parseInt(br.readLine());
		int width = 1, height = 1;

		int dirX = (x + t) / w;
		int newX = (x + t) % w;
		int dirY = (y + t) / h;
		int newY = (y + t) % h;

		if(dirX % 2 == 0)
			x = newX;
		else
			x = w - newX;

		if(dirY % 2 == 0)
			y = newY;
		else
			y = h - newY;

		System.out.println(x + " " + y);
	}
}
