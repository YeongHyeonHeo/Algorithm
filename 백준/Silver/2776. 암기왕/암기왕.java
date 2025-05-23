import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static int[] n, m;

    static void input() {
        N = scan.nextInt();
        n = new int[N + 1];
        for (int i = 1; i <= N; i++) n[i] = scan.nextInt();
        M = scan.nextInt();
        m = new int[M + 1];
        for (int i = 1; i <= M; i++) m[i] = scan.nextInt();
    }

    static boolean binary_search(int L, int R, int num) {
        while (L <= R) {
            int mid = (L + R) / 2;
            if (num > n[mid]) L = mid + 1;
            else if (num < n[mid]) R = mid -1;
            else return true;
        }
        return false;
    }

    static void pro() {
        Arrays.sort(n, 1, N+1);
        for (int i = 1; i <= M; i++) {
            if (binary_search(1, N, m[i])) sb.append("1\n");
            else sb.append("0\n");
        }
    }

    public static void main(String[] args) {
        int T = scan.nextInt();
        while (T-- > 0) {
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