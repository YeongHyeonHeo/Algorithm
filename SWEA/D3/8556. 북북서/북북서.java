import java.io.*;
import java.util.*;

public class Solution {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static String str;
    static Stack<Integer> stack;

    static void input() {
        str = scan.nextLine();
        stack = new Stack<>();
    }

    static void pro() {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'n') {
                stack.push(0);
                i += 4;
            } else {
                stack.push(1);
                i += 3;
            }
        }

        int a = 0, b = 1;
        if (stack.pop() == 1) a += 90;
        while (!stack.isEmpty()) {
            a *= 2;
            b *= 2;
            if (stack.pop() == 0) a -= 90;
            else a += 90;
        }
        while (a % 2 == 0 && b % 2 == 0) {
            a /= 2;
            b /= 2;
        }
        if (b == 1) sb.append(a).append('\n');
        else sb.append(a).append('/').append(b).append('\n');
    }

    public static void main(String[] args) {
        int T = scan.nextInt();
        for (int t = 1; t <= T; t++) {
            sb.append('#').append(t).append(' ');
            input();
            pro();
        }
        System.out.print(sb);
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

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}