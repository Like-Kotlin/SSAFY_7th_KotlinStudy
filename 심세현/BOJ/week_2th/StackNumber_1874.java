package beckjoon.stack;

import java.util.Scanner;
import java.util.Stack;

public class StackNumber_1874 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> st = new Stack<>();
        StringBuilder sb = new StringBuilder();

        int n = sc.nextInt();
        int start = 0;
        while(n-- > 0){
            int value = sc.nextInt();

            while(value > start){
                st.push(++start);
                sb.append("+\n");
            }

            if(!st.isEmpty() && st.peek() != value){
                System.out.println("NO");
                return;
            }

            st.pop();
            sb.append("-\n");
        }

        System.out.println(sb);
    }
}


