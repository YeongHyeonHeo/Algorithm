import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int n, k;
    static int[] a, par;

    static void input() {
        n = scan.nextInt();
        k = scan.nextInt();
        a = new int[n + 1];
        par = new int[n + 1];
        for (int i = 1; i <= n; i++) a[i] = scan.nextInt();
    }

    static void pro() {
        par[0] = -1;
        par[1] = 0;

        int last = 1;
        for (int i = 2; i <= n; i++, last++) {
            for (; i <= n; i++) {
                par[i] = last;
                if (i < n && a[i] + 1 != a[i + 1]) break;
            }
        }

        int kIdx = 0;
        for (int i = 1; i <= n; i++) {
            if (a[i] == k) kIdx = i;
        }
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (par[par[i]] == par[par[kIdx]] && par[i] != par[kIdx]) ans++;
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        while (true) {
            input();
            if (n == 0 && k == 0) break;
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