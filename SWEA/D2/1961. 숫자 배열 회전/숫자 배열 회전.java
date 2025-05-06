import java.io.*;
import java.util.*;

public class Solution {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[][] A;
    static String[][] B;

    static void input() {
        N = scan.nextInt();
        A = new int[N][N];
        B = new String[N][3];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) A[i][j] = scan.nextInt();
        }
    }

    static void pro() {
        // 90
        for (int i = 0; i < N; i++) {
            String str = "";
            for (int j = N-1; j >= 0; j--) str += Integer.toString(A[j][i]);
            B[i][0] = str;
        }

        // 180
        for (int i = N-1; i >= 0; i--) {
            String str = "";
            for (int j = N-1; j >= 0; j--) str += Integer.toString(A[i][j]);
            B[N-i-1][1] = str;
        }

        // 270
        for (int i = N-1; i >= 0; i--) {
            String str = "";
            for (int j = 0; j < N; j++) str += Integer.toString(A[j][i]);
            B[N-i-1][2] = str;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 3; j++) sb.append(B[i][j]).append(' ');
            sb.append('\n');
        }
    }

    public static void main(String[] args) {
        int T = scan.nextInt();
        for (int t = 1; t <= T; t++) {
            sb.append('#').append(t).append('\n');
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