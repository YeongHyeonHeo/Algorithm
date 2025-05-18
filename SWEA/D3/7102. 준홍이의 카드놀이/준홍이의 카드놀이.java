import java.io.*;
import java.util.*;

public class Solution {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static int[] sum;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        sum = new int[N+M+1];
    }

    static void pro() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) sum[i+j]++;
        }
        int max = 0;
        for (int i = 2; i <= N + M; i++) {
            if (max <= sum[i]) max = sum[i];
        }
        for (int i = 2; i <= N + M; i++) {
            if (max == sum[i]) sb.append(i).append(' ');
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