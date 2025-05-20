import java.io.*;
import java.util.*;

public class Solution {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, D;
    static int[] A;

    static void input() {
        N = scan.nextInt();
        D = scan.nextInt();
        A = new int[N+2];
        A[0] = 1; A[N+1] = 1;
        for (int i = 1; i <= N; i++) A[i] = scan.nextInt();
    }

    static void pro() {
        int cnt = 0;
        for (int i = 0; i < N+2-D; i++) {
            boolean flag = true;
            for (int j = 1; j <= D; j++) {
                if (A[i+j] == 1) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                cnt++;
                A[i+D] = 1;
            }
        }
        sb.append(cnt).append('\n');
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