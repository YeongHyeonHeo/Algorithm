import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[] parent;
    static boolean[] check;

    static void input() {
        N = scan.nextInt();
        parent = new int[N + 1];
        check = new boolean[N + 1];
        for (int i = 1; i < N; i++) {
            int x = scan.nextInt(), y = scan.nextInt();
            parent[y] = x;
        }
    }

    static void pro() {
        int x = scan.nextInt(), y = scan.nextInt();

        // x 에서 루트까지 체크
        while (x != 0) {
            check[x] = true;
            x = parent[x];
        }

        // y 에서 루트로 이동하면서 처음으로 만나는 체크된 정점
        while (!check[y]) y = parent[y];

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