import java.io.*;
import java.util.*;

public class Solution {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int t;
    static int[][] A;

    static void input() {
        t = scan.nextInt();
        A = new int[100][100];
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) A[i][j] = scan.nextInt();
        }
    }

    static void pro() {
        int ans = Integer.MIN_VALUE;
        int sum1 = 0, sum2 = 0;
        for (int i = 0; i < 100; i++) {
            int rowSum = 0, colSum = 0;
            for (int j = 0; j < 100; j++) {
                rowSum += A[i][j];
                colSum += A[j][i];
            }
            sum1 += A[i][i];
            sum2 += A[i][99-i];
            ans = Math.max(ans, Math.max(rowSum, colSum));
        }
        ans = Math.max(ans, Math.max(sum1, sum2));
        sb.append(ans).append('\n');
    }

    public static void main(String[] args) {
        for (int t = 1; t <= 10; t++) {
            sb.append('#').append(t).append(' ');
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