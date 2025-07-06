import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();

    static int N, K;

    static void input() {
        N = scan.nextInt();
        K = scan.nextInt();
    }

    static int fac(int n) {
        if (n == 1 || n == 0) return 1;
        return n * fac(n - 1);
    }

    static void pro() {
        System.out.println(fac(N) / (fac(N-K) * fac(K)));
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