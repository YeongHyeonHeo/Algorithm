import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int n, x;
    static int[] a;

    static void input() {
        n = scan.nextInt();
        a = new int[n + 1];
        for (int i = 1; i <= n; i++) a[i] = scan.nextInt();
        x = scan.nextInt();
    }

    static void pro() {
        Arrays.sort(a, 1, n + 1);
        int L = 1, R = n, ans = 0;
        while (L < R) {
            if (a[L] + a[R] == x) {
                L++; R--;
                ans++;
            } else if (a[L] + a[R] > x) R--;
            else L++;
        }
        System.out.println(ans);
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