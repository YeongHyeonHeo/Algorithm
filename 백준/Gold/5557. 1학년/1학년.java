import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[] A;
    static long[][] Dy;

    static void input() {
        N = scan.nextInt();
        A = new int[N + 1];
        Dy = new long[N + 1][21];
        for (int i = 1; i <= N; i++) A[i] = scan.nextInt();
    }

    static void pro() {
        Dy[1][A[1]] = 1;

        for (int i = 2; i <= N - 1; i++) {
            for (int prev = 0; prev <= 20; prev++) {
                for (int cur : new int[]{prev + A[i], prev - A[i]}) {
                    if (0 > cur || cur > 20) continue;
                    Dy[i][cur] += Dy[i-1][prev];
                }
            }
        }

        System.out.println(Dy[N-1][A[N]]);
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