import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();

    static long[] Dy;

    static void pro() {
        Dy = new long[101];
        Dy[1] = Dy[2] = Dy[3] = 1;
        for (int i = 4; i <= 100; i++) Dy[i] = Dy[i-2] + Dy[i-3];
    }

    public static void main(String[] args) {
        pro();
        int T = scan.nextInt();
        while (T-- > 0) {
            int N = scan.nextInt();
            System.out.println(Dy[N]);
        }
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
    }
}