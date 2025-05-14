import java.io.*;
import java.util.*;

public class Solution {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M, ans;
    static int[] A, selected;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        A = new int[N + 1];
        selected = new int[3];
        for (int i = 1; i <= N; i++) A[i] = scan.nextInt();
        ans = 0;
    }

    static void rec_func(int k) {
        if (k == 3) {
            int sum = A[selected[1]] + A[selected[2]];
            if (sum <= M) ans = Math.max(ans, sum);
        } else {
            for (int cand = selected[k-1]+1; cand <= N; cand++) {
                selected[k] = cand;
                rec_func(k + 1);
            }
        }
    }

    static void pro() {
        rec_func(1);
        if (ans == 0) sb.append("-1\n");
        else sb.append(ans).append('\n');
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