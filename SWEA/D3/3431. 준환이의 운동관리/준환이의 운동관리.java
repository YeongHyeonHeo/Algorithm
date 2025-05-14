import java.io.*;
import java.util.*;

public class Solution {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int L, U, X;

    static void input() {
        L = scan.nextInt();
        U = scan.nextInt();
        X = scan.nextInt();
    }

    static void pro() {
        if (X < L) sb.append(L-X).append('\n');
        else if (X > U) sb.append("-1\n");
        else sb.append("0\n");
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