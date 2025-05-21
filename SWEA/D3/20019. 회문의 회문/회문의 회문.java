import java.io.*;
import java.util.*;

public class Solution {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static String S;

    static void input() {
        S = scan.nextLine();
    }

    static void pro() {
        int N = S.length();
        for (int i = 0; i < N/2; i++) {
            if (S.charAt(i) != S.charAt(N-i-1)) {
                sb.append("NO\n");
                return;
            }
        }
        N = (N-1)/2;
        for (int i = 0; i < N/2; i++) {
            if (S.charAt(i) != S.charAt(N-i-1)) {
                sb.append("NO\n");
                return;
            }
        }
        int a = S.length()/2+1, b = S.length()-1;
        for (int i = 0; i < N/2; i++) {
            if (S.charAt(a) != S.charAt(b)) {
                sb.append("NO\n");
                return;
            }
            a++; b--;
        }
        sb.append("YES\n");
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