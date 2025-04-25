import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, S, M;
    static int[] A;
    static boolean[][] Dy;

    static void input() {
        N = scan.nextInt();
        S = scan.nextInt();
        M = scan.nextInt();
        A = new int[N + 1];
        Dy = new boolean[N + 1][M + 1];
        for (int i = 1; i <= N; i++) A[i] = scan.nextInt();
    }

    static void pro() {
        Dy[0][S] = true;

        int ans = 0;
        for (int i = 1; i <= N; i++) {
            boolean flag = false;
            ans = 0;
            for (int j = 0; j <= M; j++) {
                if (!Dy[i-1][j]) continue;
                for (int cur : new int[]{j - A[i], j + A[i]}) {
                    if (cur < 0 || cur > M) continue;
                    Dy[i][cur] = true;
                    flag = true;
                    ans = Math.max(ans, cur);
                }
            }
            if (!flag) {
                System.out.println(-1);
                return;
            }
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