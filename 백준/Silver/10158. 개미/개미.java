import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int w, h, p, q, t;

    static void input() {
        w = scan.nextInt();
        h = scan.nextInt();
        p = scan.nextInt();
        q = scan.nextInt();
        t = scan.nextInt();
    }

    static void pro() {
        int deltaX = 1;
        int timeX = t % (2 * w);
        while (timeX-- > 0) {
            if (p == w) deltaX = -1;
            else if (p == 0) deltaX = 1;
            p += deltaX;
        }

        int deltaY = 1;
        int timeY = t % (2 * h);
        while (timeY-- > 0) {
            if (q == h) deltaY = -1;
            else if (q == 0) deltaY = 1;
            q += deltaY;
        }

        sb.append(p).append(' ').append(q);
        System.out.print(sb);
    }

    public static void main(String[] args) {
        input();
        pro();
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