import java.io.*;
import java.util.*;

public class Solution {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M, Q;
    static String[] s, t;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        s = new String[N + 1];
        t = new String[M + 1];
        for (int i = 1; i <= N; i++) s[i] = scan.next();
        for (int i = 1; i <= M; i++) t[i] = scan.next();
    }

    static void pro() {
        Q = scan.nextInt();
        while (Q-- > 0) {
            int q = scan.nextInt();
            if (q % N != 0) sb.append(s[q % N]);
            else sb.append(s[N]);
            if (q % M != 0) sb.append(t[q % M]).append(' ');
            else sb.append(t[M]).append(' ');
        }
        sb.append('\n');
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