import java.io.*;
import java.util.*;

public  class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, MOD = 1000000000;
    static int[][] Dy;

    static void input() {
        N = scan.nextInt();
        Dy = new int[N + 1][10];
    }

    static void pro() {
        for (int i = 1; i <= 9; i++) Dy[1][i] = 1;

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j <= 9; j++) {
                for (int cur : new int[]{j - 1, j + 1}) {
                    if (0 > cur || cur > 9) continue;
                    Dy[i][j] += Dy[i-1][cur];
                    Dy[i][j] %= MOD;
                }
            }
        }

        int ans = 0;
        for (int i = 0; i <= 9; i++) {
            ans += Dy[N][i];
            ans %= MOD;
        }
        System.out.println(ans);
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