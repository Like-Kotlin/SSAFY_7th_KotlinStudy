import java.util.*;
import java.io.*;

public class Solution {
    static int cnt, result, A, B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String s1 = st.nextToken();
        String s2 = st.nextToken();

        int[] s1Arr = new int[37];
        int[] s2Arr = new int[37];

        s1Arr = calculateN(s1);
        s2Arr = calculateN(s2);

        cnt = 0;
        result = 0;
        A = 0;
        B = 0;

        findCnt(s1Arr, s2Arr);

        String result = printResult();
        System.out.println(result);
    }

    private static int[] calculateN(String input) {
        int[] arr = new int[37];
        Arrays.fill(arr, -1);

        for (int i = 2; i <= 36; i++) {
            try {
                arr[i] = Integer.parseInt(input, i);
            } catch (Exception e) {
                continue;
            }
        }
        return arr;
    }

    private static void findCnt(int[] arr1, int[] arr2) {
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] == -1) {
                continue;
            }
            for (int j = 0; j < arr2.length; j++) {
                if (arr2[j] == -1) {
                    continue;
                }

                if (arr1[i] == arr2[j] && i != j) {
                    cnt++;
                    result = arr1[i];
                    A = i;
                    B = j;
                }
            }
        }
    }

    private static String printResult() {
        String ans = "";

        if (cnt == 0) {
            ans = "Impossible";
        } else if (cnt == 1) {
            ans = result + " " + A + " " + B;
        } else {
            ans = "Multiple";
        }

        return ans;
    }
}