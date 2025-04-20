import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int[][] Dy;

    static void preprocess() {
        Dy = new int[41][2];
        Dy[0][0] = 1;   Dy[0][1] = 0;
        Dy[1][0] = 0;   Dy[1][1] = 1;
        Dy[2][0] = 1;   Dy[2][1] = 1;
        for (int i = 3; i <= 40; i++) {
            Dy[i][0] = Dy[i-1][0] + Dy[i-2][0];
            Dy[i][1] = Dy[i-1][1] + Dy[i-2][1];
        }
    }

    static void pro() {
        int T = scan.nextInt();
        while (T-- > 0) {
            int N = scan.nextInt();
            sb.append(Dy[N][0]).append(' ').append(Dy[N][1]).append('\n');
        }
        System.out.println(sb);
    }

    public static void main(String[] args) {
        preprocess();
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