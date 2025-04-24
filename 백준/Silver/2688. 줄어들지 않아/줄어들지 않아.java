import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int n;
    static long[][] Dy;

    static void input() {
        n = scan.nextInt();
    }

    static void preprocess() {
        Dy = new long[65][10];

        for (int i = 0; i <= 9; i++) Dy[1][i] = 1;

        for (int i = 2; i <= 64; i++) {
            for (int j = 0; j <= 9; j++) {
                for (int k = 0; k <= j; k++)
                    Dy[i][j] += Dy[i-1][k];
            }
        }
    }

    static void pro() {
        long ans = 0;
        for (int i = 0; i <= 9; i++) ans += Dy[n][i];
        System.out.println(ans);
    }

    public static void main(String[] args) {
        preprocess();
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