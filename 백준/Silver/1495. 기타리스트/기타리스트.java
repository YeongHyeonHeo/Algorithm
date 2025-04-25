import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, S, M;
    static int[] A;
    static int[][] Dy;

    static void input() {
        N = scan.nextInt();
        S = scan.nextInt();
        M = scan.nextInt();
        A = new int[N + 1];
        Dy = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) A[i] = scan.nextInt();
    }

    static void pro() {
        if (S - A[1] >= 0) Dy[1][S - A[1]] = 1;
        if (S + A[1] <= M) Dy[1][S + A[1]] = 1;

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j <= M; j++) {
                for (int cur : new int[]{j - A[i], j + A[i]}) {
                    if (cur < 0 || cur > M) continue;
                    Dy[i][cur] += Dy[i - 1][j];
                }
            }
        }

        for (int i = M; i >= 0; i--) {
            if (Dy[N][i] != 0) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(-1);
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