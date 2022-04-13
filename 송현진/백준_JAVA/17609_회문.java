import java.util.*;
import java.io.*;

public class Solution {
    static char[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            arr = input.toCharArray();
            int left = 0;
            int right = arr.length - 1;
            sb.append(findPalindrome(left, right) + "\n");
        }
        System.out.print(sb);
    }

    public static int findPalindrome(int left, int right) {
        if (check(left, right)) {
            return 0;
        }

        if (checkLR(left, right)) {
            return 1;
        } else {
            return 2;
        }
    }

    public static boolean check(int left, int right) {

        while (left <= right) {
            if (arr[left] != arr[right]) {
                return false;
            }
            left += 1;
            right -= 1;
        }
        return true;
    }

    public static boolean checkLR(int left, int right) {
        while (left <= right) {
            if (arr[left] != arr[right]) {
                boolean a = check(left + 1, right);
                boolean b = check(left, right - 1);
                if (a == false && b == false) {
                    return false;
                } else {
                    return true;
                }
            }
            left += 1;
            right -= 1;
        }
        return true;
    }
}