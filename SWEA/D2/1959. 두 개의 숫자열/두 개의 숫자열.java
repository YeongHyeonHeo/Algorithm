import java.io.*;
import java.util.*;

public class Solution {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static int[] A, B;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        A = new int[N];
        B = new int[M];
        for (int i = 0; i < N; i++) A[i] = scan.nextInt();
        for (int i = 0; i < M; i++) B[i] = scan.nextInt();
    }

    static void pro() {
        int time = Math.abs(N - M) + 1;
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < time; i++) {
            int sum = 0;
            for (int j = 0; j < Math.min(N, M); j++) {
                if (N < M) sum += A[j] * B[j + i];
                else sum += A[j + i] * B[j];
            }
            ans = Math.max(ans, sum);
        }
        sb.append(ans).append('\n');
    }

    public static void main(String[] args) {
        int T = scan.nextInt();
        for (int t = 1; t <= T; t++) {
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