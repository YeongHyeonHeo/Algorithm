import java.io.*;
import java.util.*;

public class Solution {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int h1, m1, h2, m2;

    static void input() {
        h1 = scan.nextInt();
        m1 = scan.nextInt();
        h2 = scan.nextInt();
        m2 = scan.nextInt();
    }

    static void pro() {
        int h3 = h1 + h2;
        int m3 = m1 + m2;
        if (m3 > 59) {
            m3 -= 60;
            h3++;
        }
        if (h3 > 12) h3 -= 12;
        sb.append(h3).append(' ').append(m3).append('\n');
    }

    public static void main(String[] args) {
        int T = scan.nextInt();
        for (int t = 1; t <= T; t++) {
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