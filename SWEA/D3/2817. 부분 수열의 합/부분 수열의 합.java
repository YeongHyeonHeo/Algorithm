import java.io.*;
import java.util.*;

public class Solution {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, K, ans;
    static int[] A, selected;

    static void input() {
        N = scan.nextInt();
        K = scan.nextInt();
        A = new int[N + 1];
        selected = new int[N + 1];
        for (int i = 1; i <= N; i++) A[i] = scan.nextInt();
        ans = 0;
    }

    static void rec_func(int k, int n) {
        if (k == n + 1) {
            int sum = 0;
            for (int i = 1; i <= n; i++) sum += A[selected[i]];
            if (sum == K) ans++;
        } else {
            for (int cand = selected[k-1]+1; cand <= N; cand++) {
                selected[k] = cand;
                rec_func(k+1, n);
            }
        }
    }

    static void pro() {
        for (int i = 1; i <= N; i++) {
            rec_func(1, i);
        }
        sb.append(ans).append('\n');
    }

    public static void main(String[] args) {
        int T = scan.nextInt();
        for (int t = 1; t <= T; t++) {
            sb.append('#').append(t).append(' ');
            input();
            pro();
        }
        System.out.print(sb);
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