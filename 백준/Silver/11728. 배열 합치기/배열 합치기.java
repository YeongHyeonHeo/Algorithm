import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static int[] A, B;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        A = new int[N + 1];
        B = new int[M + 1];
        for (int i = 1; i <= N; i++) A[i] = scan.nextInt();
        for (int i = 1; i <= M; i++) B[i] = scan.nextInt();
    }

    static void pro() {
        int L = 1, R = 1;
        while (L < N + 1 && R < M + 1) {
            if (A[L] > B[R]) {
                sb.append(B[R]).append(' ');
                R++;
            } else {
                sb.append(A[L]).append(' ');
                L++;
            }
        }
        if (L == N + 1) {
            for (int i = R; i <= M; i++) sb.append(B[i]).append(' ');
        } else {
            for (int i = L; i <= N; i++) sb.append(A[i]).append(' ');
        }
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