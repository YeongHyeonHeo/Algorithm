import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int n;
    static int[] arr;
    static char[] ans;

    static void input() {
        n = scan.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = scan.nextInt();
        ans = new char[n * 2];
    }

    static void pro() {
        Stack<Integer> stack = new Stack<>();
        int idx = 0;
        for (int i = 1; i <= arr[0]; i++) {
            stack.push(i);
            ans[idx++] = '+';
        }
        int recent = stack.pop();
        ans[idx++] = '-';

        for (int i = 1; i < n; i++) {
            if (!stack.empty()) {
                if (stack.peek() == arr[i]) {
                    stack.pop();
                    ans[idx++] = '-';
                } else if (stack.peek() < arr[i]) {
                    for (int j = recent + 1; j <= arr[i]; j++) {
                        stack.push(j);
                        ans[idx++] = '+';
                    }
                    recent = stack.pop();
                    ans[idx++] = '-';
                } else {
                    System.out.println("NO");
                    return;
                }
            } else {
                for (int j = recent + 1; j <= arr[i]; j++) {
                    stack.push(j);
                    ans[idx++] = '+';
                }
                recent = stack.pop();
                ans[idx++] = '-';
            }
        }
        for (char c : ans) sb.append(c).append('\n');
        System.out.print(sb);
    }

    public static void main(String[] args) {
        input();
        pro();
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}