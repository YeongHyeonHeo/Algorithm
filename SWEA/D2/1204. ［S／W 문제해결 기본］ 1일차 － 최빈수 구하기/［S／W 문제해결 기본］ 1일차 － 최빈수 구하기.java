import java.io.*;
import java.util.*;

public class Solution {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int[] A;
    static int[] cnt;

    static void input() {
        A = new int[1000];
        cnt = new int[101];
        for (int i = 0; i < 1000; i++) A[i] = scan.nextInt();
    }

    static void pro() {
        for (int i = 0; i < 1000; i++) cnt[A[i]]++;
        int max = 0, idx = 0;
        for (int i = 0; i < 101; i++) {
            if (max <= cnt[i]) {
                max = cnt[i];
                idx = i;
            }
        }
        sb.append(idx).append('\n');
    }

    public static void main(String[] args) {
        int T = scan.nextInt();
        while (T-- > 0) {
            int t = scan.nextInt();
            sb.append('#').append(t).append(' ');
            input();
            pro();
        }
        System.out.println(sb);
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