import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static int[] A;

    static void input() {
        N = scan.nextInt();
        A = new int[N + 1];
        for (int i = 1; i <= N; i++) A[i] = scan.nextInt();
        M = scan.nextInt();
    }

    static boolean determination(int money) {
        int sum = 0;
        for (int i = 1; i <= N; i++) {
            if (A[i] <= money) sum += A[i];
            else sum += money;
        }
        return sum <= M;
    }

    static void pro() {
        int L = 0, R = M, ans = 0, sum = 0;
        Arrays.sort(A, 1, N + 1);
        for (int i = 1; i <= N; i++) sum += A[i];
        if (sum <= M) ans = A[N];
        else {
            while (L <= R) {
                int mid = (L + R) / 2;
                if (determination(mid)) {
                    ans = mid;
                    L = mid + 1;
                } else R = mid - 1;
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        input();
        pro();
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