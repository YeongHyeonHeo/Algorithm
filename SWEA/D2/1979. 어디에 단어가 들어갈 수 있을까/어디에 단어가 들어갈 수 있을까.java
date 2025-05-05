import java.io.*;
import java.util.*;

public class Solution {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, K;
    static int[][] A;

    static void input() {
        N = scan.nextInt();
        K = scan.nextInt();
        A = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) A[i][j] = scan.nextInt();
        }
    }

    static void pro() {
        int ans = 0;
        for (int i = 1; i <= N; i++) {
            int cnt = 0, cnt2 = 0;
            for (int j = 1; j <= N; j++) {
                if (A[i][j] == 1) cnt++;
                else cnt = 0;
                if (j + 1 <= N) {
                    if (cnt == K && A[i][j+1] == 0) ans++;
                } else {
                    if (cnt == K) ans++;
                }

                if (A[j][i] == 1) cnt2++;
                else cnt2 = 0;
                if (j + 1 <= N) {
                    if (cnt2 == K && A[j+1][i] == 0) ans++;
                } else {
                    if (cnt2 == K) ans++;
                }
            }
        }
        sb.append(ans).append('\n');
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