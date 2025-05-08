import java.io.*;
import java.util.*;

public class Solution {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[][] A;

    static void input() {
        N = scan.nextInt();
        A = new int[N][2];
        for (int i = 0; i < N; i++) {
            int command = scan.nextInt();
            int ms = 0;
            if (command != 0) ms = scan.nextInt();
            A[i][0] = command;
            A[i][1] = ms;
        }
    }

    static void pro() {
        int sum = 0, ms = 0;
        for (int i = 0; i < N; i++) {
            if (A[i][0] == 0) sum += ms;
            else if (A[i][0] == 1) {
                ms += A[i][1];
                sum += ms;
            } else {
                ms -= A[i][1];
                if (ms < 0) ms = 0;
                sum += ms;
            }
        }
        sb.append(sum).append('\n');
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