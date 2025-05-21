import java.io.*;
import java.util.*;

public class Solution {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static String[][] n;
    static String[] m;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        n = new String[N][2];
        m = new String[M];
        for (int i = 0; i < N; i++) {
            n[i][0] = scan.next();
            n[i][1] = scan.next();
        }
        for (int i = 0; i < M; i++) m[i] = scan.nextLine();
    }

    static boolean isValid(int i, int j) {
        boolean flag = true;
        for (int idx = 0; idx < 8; idx++) {
            if (n[j][0].charAt(idx) == '*') continue;
            if (n[j][0].charAt(idx) != m[i].charAt(idx)) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    static void pro() {
        int sum = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (isValid(i, j)) {
                    int money = Integer.parseInt(n[j][1]);
                    sum += money;
                }
            }
        }
        sb.append(sum).append('\n');
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