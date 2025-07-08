import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();

    static int N;

    static void input() {
        N = scan.nextInt();
    }

    static void pro() {
        int cnt = 0;
        while (N >= 5) {
            cnt += N / 5;
            N /= 5;
        }
        System.out.println(cnt);
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
    }
}