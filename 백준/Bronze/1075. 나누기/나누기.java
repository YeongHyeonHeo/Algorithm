import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, F;

    static void input() {
        N = scan.nextInt();
        F = scan.nextInt();
    }

    static void pro() {
        int n = N - (N % 100), ans = 0;
        for (int i = 0; i < 100; i++) {
            if ((n + i) % F == 0) {
                ans = i;
                break;
            }
        }

        if (ans < 10) sb.append(0).append(ans);
        else sb.append(ans);
        System.out.println(sb);
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