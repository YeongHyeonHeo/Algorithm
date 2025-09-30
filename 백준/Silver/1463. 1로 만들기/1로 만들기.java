import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[] dp;

    static void input() {
        N = scan.nextInt();
        dp = new int[N+1];
    }

    static void pro() {
        dp[0] = dp[1] = 0;
        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i-1] + 1;
            if (i % 2 == 0) dp[i] = Math.min(dp[i], dp[i/2] + 1);
            if (i % 3 == 0) dp[i] = Math.min(dp[i], dp[i/3] + 1);
        }
        sb.append(dp[N]);
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