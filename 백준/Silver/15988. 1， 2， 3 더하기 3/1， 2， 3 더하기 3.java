import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int[] Dy;

    static void preprocess() {
        Dy = new int[1000000 + 1];
        Dy[1] = 1;
        Dy[2] = 2;
        Dy[3] = 4;
        for (int i = 4; i <= 1000000; i++)
            Dy[i] = (int)(((long)Dy[i-1] + Dy[i-2] + Dy[i-3]) % 1000000009);
    }

    static void pro() {
        int T = scan.nextInt();
        while (T-- > 0) {
            int n = scan.nextInt();
            sb.append(Dy[n]).append('\n');
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