import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] num = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
        ArrayList<Long> arr = new ArrayList<>();
        // 전체 케이스를 찾아서 배열에 저잗ㅇ한다.

        // 해당 자리를 선택하거나 안할 수 있으므로 중복을 제외하여 2^10가지가 나오게 된다.
        // 1<<10 은 2의 10승을 뜻하므로 1024값이 나온다. 
        for (int i = 1; i < (1 << 10); i++) {
            long sum = 0;
            // 0~9까지의 숫자 선택 
            for (int j = 0; j < 10; j++) {
                // 
                if ((i & (1 << j)) > 0) {
                    sum = sum * 10 + num[j];
                }
            }
            arr.add(sum);
        }
        Collections.sort(arr);
        if (N > arr.size()) {
            System.out.println(-1);
        } else {
            System.out.println(arr.get(N - 1));
        }
        sc.close();
    }
}