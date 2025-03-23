import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static int[] A, B;

    static void input() {
        N = scan.nextInt();
        A = new int[N + 1];
        for (int i = 1; i <= N; i++) A[i] = scan.nextInt();
        M = scan.nextInt();
        B = new int[M + 1];
        for (int i = 1; i <= M; i++) B[i] = scan.nextInt();
    }

    static int contain(int[] A, int L, int R, int X) {
        int res = 0;
        while (L <= R) {
            int mid = (L + R) / 2;
            if (A[mid] < X) L = mid + 1;
            else if (A[mid] > X) R = mid - 1;
            else {
                res = 1;
                break;
            }
        }
        return res;
    }

    static void pro() {
        Arrays.sort(A, 1, N + 1);
        for (int i = 1; i <= M; i++) {
            System.out.println(contain(A, 1, N, B[i]));
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