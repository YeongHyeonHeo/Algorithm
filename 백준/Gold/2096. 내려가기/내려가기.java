import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[] A;
    static int[][] Dy_max, Dy_min;

    static void input() {
        N = scan.nextInt();
        A = new int[3];
        Dy_max = new int[N + 1][3];
        Dy_min = new int[N + 1][3];
    }

    static void pro() {
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < 3; j++) A[j] = scan.nextInt();
            Dy_max[i][0] = Math.max(Dy_max[i-1][0], Dy_max[i-1][1]) + A[0];
            Dy_max[i][1] = Math.max(Dy_max[i-1][0], Math.max(Dy_max[i-1][1], Dy_max[i-1][2])) + A[1];
            Dy_max[i][2] = Math.max(Dy_max[i-1][1], Dy_max[i-1][2]) + A[2];
            Dy_min[i][0] = Math.min(Dy_min[i-1][0], Dy_min[i-1][1]) + A[0];
            Dy_min[i][1] = Math.min(Dy_min[i-1][0], Math.min(Dy_min[i-1][1], Dy_min[i-1][2])) + A[1];
            Dy_min[i][2] = Math.min(Dy_min[i-1][1], Dy_min[i-1][2]) + A[2];
        }

        sb.append(Math.max(Dy_max[N][0], Math.max(Dy_max[N][1], Dy_max[N][2]))).append(' ')
                .append(Math.min(Dy_min[N][0], Math.min(Dy_min[N][1], Dy_min[N][2])));
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