import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[][] A, Dy;

    static void input() {
        N = scan.nextInt();
        A = new int[N + 1][3];
        Dy = new int[N + 1][3];
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < 3; j++) A[i][j] = scan.nextInt();
        }
    }

    static void pro() {
        Dy[1][0] = A[1][0];
        Dy[1][1] = A[1][1];
        Dy[1][2] = A[1][2];

        for (int i = 2; i <= N; i++) {
            Dy[i][0] = Math.min(Dy[i-1][1], Dy[i-1][2]) + A[i][0];
            Dy[i][1] = Math.min(Dy[i-1][0], Dy[i-1][2]) + A[i][1];
            Dy[i][2] = Math.min(Dy[i-1][0], Dy[i-1][1]) + A[i][2];
        }

        int min = Dy[N][0];
        for (int i = 1; i <= 2; i++) {
            if (Dy[N][i] < min) min = Dy[N][i];
        }
        System.out.println(min);
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