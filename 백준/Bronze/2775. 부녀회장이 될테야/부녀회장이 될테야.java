import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int[][] dp;

    static void pro() {
        dp = new int[15][15];
        for (int i = 1; i <= 14; i++) dp[0][i] = i;
        for (int i = 1; i <= 14; i++) {
            for (int j = 1; j <= 14; j++) dp[i][j] = dp[i][j-1] + dp[i-1][j];
        }
    }

    public static void main(String[] args) {
        pro();
        int T = scan.nextInt();
        while (T-- > 0) {
            int k = scan.nextInt();
            int n = scan.nextInt();
            sb.append(dp[k][n]).append('\n');
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