import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[] par;
    static boolean[] check;

    static void input() {
        N = scan.nextInt();
        par = new int[N + 1];
        check = new boolean[N + 1];
        for (int i = 0; i < N - 1; i++) {
            int x = scan.nextInt(), y = scan.nextInt();
            par[y] = x;
        }
    }

    static void pro() {
        int x = scan.nextInt(), y = scan.nextInt();
        while (x != 0) {
            check[x] = true;
            x = par[x];
        }
        while (!check[y]) y = par[y];
        System.out.println(y);
    }

    public static void main(String[] args) {
        int T = scan.nextInt();
        while (T > 0) {
            T--;
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