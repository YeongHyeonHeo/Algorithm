import java.io.*;
import java.util.*;

public class Solution {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int change, max;
    static String str;
    static int[] A;
    static boolean[][] visited;

    static void input() {
        str = scan.next();
        change = scan.nextInt();
        A = new int[str.length()];
        for (int i = 0; i < A.length; i++) A[i] = str.charAt(i) - '0';
        max = 0;
        visited = new boolean[11][1000000];
    }

    static int toInt(int[] A) {
        String num = "";
        for (int i = 0; i < A.length; i++) num += Integer.toString(A[i]);
        return Integer.parseInt(num);
    }

    static void dfs(int N) {
        if (N == change) {
            max = Math.max(max, toInt(A));
            return;
        }

        for (int i = 0; i < A.length-1; i++) {
            for (int j = i+1; j < A.length; j++) {
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;

                if (!visited[N][toInt(A)]) dfs(N + 1);
                visited[N][toInt(A)] = true;

                // 원상복구
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