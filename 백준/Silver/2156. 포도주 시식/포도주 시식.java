import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[] A, Dy;

    static void input() {
        N = scan.nextInt();
        A = new int[N + 1];
        Dy = new int[N + 1];
        for (int i = 1; i <= N; i++) A[i] = scan.nextInt();
    }

    static void pro() {
        Dy[1] = A[1];
        if (N >= 2) Dy[2] = A[1] + A[2];

        for (int i = 3; i <= N; i++) {
            if (i == 3) Dy[3] = Math.max(Dy[2], Math.max(A[1]+A[3], A[2]+A[3]));
            else Dy[i] = Math.max(Dy[i-2] + A[i], Math.max(Dy[i-3]+A[i-1]+A[i], Dy[i-4]+A[i-2]+A[i-1]));
        }

        System.out.println(Dy[N]);
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