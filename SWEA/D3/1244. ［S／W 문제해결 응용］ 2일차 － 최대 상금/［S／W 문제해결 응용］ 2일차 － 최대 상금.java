import java.io.*;
import java.util.*;

public class Solution {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int change, max;
    static String str;
    static int[] A;

    static void input() {
        str = scan.next();
        change = scan.nextInt();
        A = new int[str.length()];
        for (int i = 0; i < A.length; i++) A[i] = str.charAt(i) - '0';
        max = 0;
    }

    static void dfs(int N) {
        if (N == change) {
            String num = "";
            for (int i = 0; i < A.length; i++) num += Integer.toString(A[i]);
            max = Math.max(max, Integer.parseInt(num));
            return;
        }

        for (int i = 0; i < A.length-1; i++) {
            for (int j = i+1; j < A.length; j++) {
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
                dfs(N + 1);
                temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
        }
    }

    static void pro() {
        if (str.length() < change) change = str.length();
        dfs(0);
        sb.append(max).append('\n');
    }

    public static void main(String[] args) {
        int T = scan.nextInt();
        for (int t = 1; t <= T; t++) {
            sb.append('#').append(t).append(' ');
            input();
            pro();
        }
        System.out.println(sb);
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

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
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