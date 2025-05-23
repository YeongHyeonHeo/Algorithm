import java.io.*;
import java.util.*;

public class Solution {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static char[] A;
    static int K;

    static void input() {
        String str = scan.next();
        K = scan.nextInt();
        A = new char[3];
        for (int i = 0; i < 3; i++) A[i] = str.charAt(i);
    }

    static void pro() {
        while (K-- > 0) {
            if (A[0] == 'o') {
                A[0] = '.';
                A[1] = 'o';
            } else if (A[1] == 'o') {
                A[0] = 'o';
                A[1] = '.';
            } else {
                A[1] = 'o';
                A[2] = '.';
            }
        }
        for (int i = 0; i < 3; i++) {
            if (A[i] == 'o') {
                sb.append(i).append('\n');
                break;
            }
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