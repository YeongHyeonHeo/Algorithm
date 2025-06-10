import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static long S;

    static void input() {
        S = scan.nextLong();
    }

    static void pro() {
        boolean ans = true;
        for (long i = 2; i <= 1000000; i++) {
            if (S % i == 0) {
                ans = false;
                break;
            }
        }
        if (ans) sb.append("YES\n");
        else sb.append("NO\n");
    }

    public static void main(String[] args) {
        int N = scan.nextInt();
        while (N-- > 0) {
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