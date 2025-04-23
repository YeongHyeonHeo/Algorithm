import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[][] A, Dy;

    static void input() {
        N = scan.nextInt();
        A = new int[2][N + 1];
        Dy = new int[N + 1][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 1; j <= N; j++) A[i][j] = scan.nextInt();
        }
    }

    static void pro() {
        Dy[1][0] = A[0][1];
        Dy[1][1] = A[1][1];
        if (N >= 2) {
            Dy[2][0] = A[1][1] + A[0][2];
            Dy[2][1] = A[0][1] + A[1][2];
        }

        for (int i = 3; i <= N; i++) {
            Dy[i][0] = Math.max(Dy[i-1][1], Dy[i-2][1]) + A[0][i];
            Dy[i][1] = Math.max(Dy[i-1][0], Dy[i-2][0]) + A[1][i];
        }

        System.out.println(Math.max(Dy[N][0], Dy[N][1]));
    }

    public static void main(String[] args) {
        int T = scan.nextInt();
        while (T-- > 0) {
            input();
            pro();
        }
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