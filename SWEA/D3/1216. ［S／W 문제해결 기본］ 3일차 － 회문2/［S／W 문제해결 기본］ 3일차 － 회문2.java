import java.io.*;
import java.util.*;

public class Solution {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int max;
    static String[] A;

    static void input() {
        A = new String[100];
        for (int i = 0; i < 100; i++) A[i] = scan.nextLine();
        max = 1;
    }

    static boolean solveRow(int i, int len) {
        for (int time = 0; time < 100-len+1; time++) {
            boolean flag = true;
            for (int k = 0; k < len/2; k++) {
                if (A[i].charAt(k+time) != A[i].charAt(time+len-k-1)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                max = len;
                return true;
            }
        }
        return false;
    }

    static boolean solveCol(int i, int len) {
        for (int time = 0; time < 100-len+1; time++) {
            boolean flag = true;
            for (int k = 0; k < len/2; k++) {
                if (A[k+time].charAt(i) != A[time+len-k-1].charAt(i)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                max = len;
                return true;
            }
        }
        return false;
    }

    static void pro(int T) {
        boolean flag = false;
        for (int len = 100; len >= 2; len--) {
            for (int i = 0; i < 100; i++) {
                if (solveRow(i, len) || solveCol(i, len)) {
                    flag = true;
                    break;
                }
            }
            if (flag) break;
        }
        if (T == 10) sb.append(max);
        else sb.append(max).append('\n');
    }

    public static void main(String[] args) {
        for (int t = 0; t < 10; t++) {
            int T = scan.nextInt();
            sb.append('#').append(T).append(' ');
            input();
            pro(T);
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