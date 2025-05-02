import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[][] A;

    static void input() {
        N = scan.nextInt();
        A = new int[N][2];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2; j++) A[i][j] = scan.nextInt();
        }
    }

    static void pro() {
        Arrays.sort(A, (o1, o2) -> o1[1] == o2[1] ? o1[0]-o2[0] : o1[1]-o2[1]);
        int cnt = 1, end = A[0][1];
        for (int i = 1; i < N; i++) {
            if (A[i][0] < end) continue;
            end = A[i][1];
            cnt++;
        }
        System.out.println(cnt);
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