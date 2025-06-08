import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int a, b, c, d, e, f;

    static void input() {
        a = scan.nextInt();
        b = scan.nextInt();
        c = scan.nextInt();
        d = scan.nextInt();
        e = scan.nextInt();
        f = scan.nextInt();
    }

    static void pro() {
        for (int x = -999; x <= 999; x++) {
            for (int y = -999; y <= 999; y++) {
                if (a*x + b*y == c && d*x + e*y == f) {
                    sb.append(x).append(' ').append(y);
                    System.out.println(sb);
                    return;
                }
            }
        }
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