import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[] cnt;

    static void input() {
        N = scan.nextInt();
        cnt = new int[2000000 + 1];
        for (int i = 0; i < N; i++) {
            int n = scan.nextInt();
            if (n >= 0) cnt[n] = 1;
            else cnt[1000000 + Math.abs(n)] = 1;
        }
    }

    static void pro() {
        for (int i = 2000000; i >= 1000001; i--) {
            if (cnt[i] == 1) sb.append(-(i - 1000000)).append('\n');
        }
        for (int i = 0; i <= 1000000; i++) {
            if (cnt[i] == 1) sb.append(i).append('\n');
        }
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