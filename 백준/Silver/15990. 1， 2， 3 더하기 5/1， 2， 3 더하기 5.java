import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static long[][] Dy;
    static int MOD = 1000000009;

    static void preprocess() {
        Dy = new long[100000 + 1][3];
        Dy[1][0] = 1;
        Dy[2][1] = 1;
        Dy[3][0] = Dy[3][1] = Dy[3][2] = 1;

        for (int i = 4; i <= 100000; i++) {
            Dy[i][0] = (Dy[i-1][1] + Dy[i-1][2]) % MOD;
            Dy[i][1] = (Dy[i-2][0] + Dy[i-2][2]) % MOD;
            Dy[i][2] = (Dy[i-3][0] + Dy[i-3][1]) % MOD;
        }
    }

    public static void main(String[] args) {
        preprocess();
        int T = scan.nextInt();
        while (T-- > 0) {
            int n = scan.nextInt();
            System.out.println((Dy[n][0] + Dy[n][1] + Dy[n][2]) % MOD);
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