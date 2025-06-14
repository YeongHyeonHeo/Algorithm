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
        int x = (p + t) % (2 * w);
        int y = (q + t) % (2 * h);

        if (x > w) x = 2 * w - x;
        if (y > h) y = 2 * h - y;

        sb.append(x).append(' ').append(y);
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