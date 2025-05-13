import java.io.*;
import java.util.*;

public class Solution {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, L;
    static int[] T, K;
    static int[][] dp;

    static void input() {
        N = scan.nextInt();
        L = scan.nextInt();
        T = new int[N + 1];
        K = new int[N + 1];
        dp = new int[N + 1][L + 1];
        for (int i = 1; i <= N; i++) {
            T[i] = scan.nextInt();
            K[i] = scan.nextInt();
        }
    }

    static void pro() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= L; j++) {
                if (K[i] > j) dp[i][j] = dp[i-1][j];
                else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-K[i]] + T[i]);
                }
            }
        }
        sb.append(dp[N][L]).append('\n');
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