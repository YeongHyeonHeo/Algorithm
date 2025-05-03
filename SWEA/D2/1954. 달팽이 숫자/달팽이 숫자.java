import java.io.*;
import java.util.*;

public class Solution {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[][] A;

    static void input() {
        N = scan.nextInt();
        A = new int[N + 1][N + 1];
    }

    static void pro() {
        if (N == 1) {
            sb.append(1).append('\n');
            return;
        }

        int j = 1;
        while (A[j][j] == 0) {
            for (int i = j; i <= N-j+1; i++) A[j][i] = A[j][i-1] + 1;
            for (int i = j+1; i <= N-j+1; i++) A[i][N-j+1] = A[i-1][N-j+1] + 1;
            for (int i = N-j; i >= j; i--) A[N-j+1][i] = A[N-j+1][i+1] + 1;
            for (int i = N-j; i > j; i--) A[i][j] = A[i+1][j] + 1;
            j++;
        }

        for (int l = 1; l <= N; l++) {
            for (int m = 1; m <= N; m++) sb.append(A[l][m]).append(' ');
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