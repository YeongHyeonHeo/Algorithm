import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, K, A, B, day;
    static int[] water;
    static boolean dead;

    static void input() {
        N = scan.nextInt();
        K = scan.nextInt();
        A = scan.nextInt();
        B = scan.nextInt();
        water = new int[N + 1];
        for (int i = 1; i <= N; i++) water[i] = K;
    }

    static void pro() {
        while (true) {
            for (int L = 1; L <= N-A+1; L+=A) {
                day++;
                int R = L + A - 1;
                for (int i = L; i <= R; i++) water[i] += B-1;
                for (int i = 1; i < L; i++) {
                    water[i]--;
                    if (water[i] == 0) {
                        dead = true;
                        break;
                    }
                }
                for (int i = R+1; i <= N; i++) {
                    water[i]--;
                    if (water[i] == 0) {
                        dead = true;
                        break;
                    }
                }
                if (dead) break;
            }
            if (dead) break;
        }
        System.out.println(day);
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