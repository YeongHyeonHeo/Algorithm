import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int n;
    static int[][] arr, dp;

    static void input() {
        n = scan.nextInt();
        arr = new int[n][n];
        dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) arr[i][j] = scan.nextInt();
        }
    }

    static void pro() {
        // dp 배열 초기화
        dp[0][0] = arr[0][0];

        // 점화식
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) dp[i][j] = dp[i-1][j] + arr[i][j];
                else if (j == i) dp[i][j] = dp[i-1][j-1] + arr[i][j];
                else dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + arr[i][j];
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            if (max < dp[n-1][i]) max = dp[n-1][i];
        }
        System.out.println(max);
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