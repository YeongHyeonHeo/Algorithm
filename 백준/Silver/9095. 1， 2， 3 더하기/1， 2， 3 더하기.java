import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int cnt;

    static void rec_func(int k, int n) {
        if (k >= n) {
            if (k == n) {
                cnt++;
            }
        } else {
            for (int i = 1; i <= 3; i++) rec_func(k + i, n);
        }
    }

    public static void main(String[] args) {
        int T = scan.nextInt();
        while (T-- > 0) {
            int n = scan.nextInt();
            cnt = 0;
            rec_func(0, n);
            sb.append(cnt).append('\n');
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