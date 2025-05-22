import java.io.*;
import java.util.*;

public class Solution {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static long[] A;

    static void input() {
        N = scan.nextInt();
        A = new long[2*N];
        for (int i = 0; i < 2*N; i++) A[i] = scan.nextInt();
    }

    static void pro() {
        boolean[] b = new boolean[2*N];
        for (int i = 0; i < 2*N; i++) {
            if (b[i]) continue;
            long original = A[i] * 4/3;
            for (int j = i+1; j < 2*N; j++) {
                if (b[j]) continue;
                if (original == A[j]) {
                    sb.append(A[i]).append(' ');
                    b[j] = true;
                    b[i] = true;
                    break;
                }
            }
        }
        sb.append('\n');
    }

    public static void main(String[] args) {
        int T = scan.nextInt();
        for (int t = 1; t <= T; t++) {
            sb.append('#').append(t).append(' ');
            input();
            pro();
        }
        System.out.print(sb);
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