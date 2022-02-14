import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ_2605_줄세우기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		List<Integer> list = new ArrayList<>();

		for(int i = 1; i <= n; i++){
			int k = sc.nextInt();
			if(k == 0){
				list.add(i);
			}
			else{
				list.add(list.size() - k, i);
			}
		}

		for(int i : list){
			System.out.print(i + " ");
		}
	}
}
