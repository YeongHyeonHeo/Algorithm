import java.io.*;
import java.util.*;

public class Solution {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, L, max;
    static int[] T, K, selected;

    static void input() {
        N = scan.nextInt();
        L = scan.nextInt();
        T = new int[N + 1];
        K = new int[N + 1];
        selected = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            T[i] = scan.nextInt();
            K[i] = scan.nextInt();
        }
        max = Integer.MIN_VALUE;
    }

    static void rec_func(int k, int M) {
        if (k == M + 1) {
            int sumK = 0, sumT = 0;
            for (int i = 1; i <= M; i++) sumK += K[selected[i]];
            if (sumK <= L) {
                for (int i = 1; i <= M; i++) sumT += T[selected[i]];
                max = Math.max(max, sumT);
            }
        } else {
            for (int cand = selected[k-1] + 1; cand <= N; cand++) {
                selected[k] = cand;
                rec_func(k+1, M);
            }
        }
    }

    static void pro() {
        for (int i = 1; i <= N; i++) {
            rec_func(1, i);
        }
        sb.append(max).append('\n');
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