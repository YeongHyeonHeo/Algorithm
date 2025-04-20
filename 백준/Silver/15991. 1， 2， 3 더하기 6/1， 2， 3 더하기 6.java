import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int MOD = 1000000009;
    static long[] Dy;

    static void preprocess() {
        Dy = new long[100000 + 1];
        Dy[0] = 1;
        Dy[1] = 1;
        Dy[2] = 2;
        Dy[3] = 2;
        Dy[4] = 3;
        Dy[5] = 3;
        for (int i = 6; i <= 100000; i++)
            Dy[i] = (Dy[i-2] + Dy[i-4] + Dy[i-6]) % MOD;
    }

    static void pro() {
        int T = scan.nextInt();
        while (T-- > 0) {
            int n = scan.nextInt();
            sb.append(Dy[n]).append('\n');
        }
        System.out.println(sb);
    }

    public static void main(String[] args) {
        preprocess();
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