import java.io.*;
import java.util.*;

public class Solution {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[][] A;

    static void input() {
        N = scan.nextInt();
        A = new int[N][2*N-1];
    }

    static void pro() {
        int col = 2*N-1;
        A[0][col/2] = 1;
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < col; j++) {
                if (j-1 > 0) A[i][j] += A[i-1][j-1];
                if (j+1 < col) A[i][j] += A[i-1][j+1];
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < col; j++) {
                if (A[i][j] != 0) sb.append(A[i][j]).append(' ');
            }
            sb.append('\n');
        }
    }

    public static void main(String[] args) {
        int T = scan.nextInt();
        for (int t = 1; t <= T; t++) {
            sb.append('#').append(t).append('\n');
            input();
            pro();
        }
        System.out.println(sb);
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