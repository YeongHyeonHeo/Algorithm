import java.io.*;
import java.util.*;

public class Solution {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static char[][] ch;

    static void input() {
        ch = new char[15][15];
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) ch[i][j] = '-';
        }
        for (int i = 0; i < 5; i++) {
            String str = scan.nextLine();
            for (int j = 0; j < str.length(); j++) ch[i][j] = str.charAt(j);
        }
    }

    static void pro() {
        String ans = "";
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 5; j++) {
                if (ch[j][i] != '-') ans += ch[j][i];
            }
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