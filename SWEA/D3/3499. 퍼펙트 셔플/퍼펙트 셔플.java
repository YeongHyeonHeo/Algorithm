import java.io.*;
import java.util.*;

public class Solution {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static String[] A;

    static void input() {
        N = scan.nextInt();
        A = new String[N];
        for (int i = 0; i < N; i++) A[i] = scan.next();
    }

    static void pro() {
        if (N % 2 == 0) {
            for (int i = 0; i < N/2; i++) {
                sb.append(A[i]).append(' ');
                sb.append(A[i+N/2]).append(' ');
            }
            sb.append('\n');
        } else {
            for (int i = 0; i <= N/2; i++) {
                if (i == N/2) {
                    sb.append(A[i]).append(' ');
                    break;
                }
                sb.append(A[i]).append(' ');
                sb.append(A[i+N/2+1]).append(' ');
            }
            sb.append('\n');
        }
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