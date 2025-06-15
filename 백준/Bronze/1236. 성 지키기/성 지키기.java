import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static String[] A;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        A = new String[N];
        for (int i = 0; i < N; i++) A[i] = scan.nextLine();
    }

    static void pro() {
        boolean[] row = new boolean[N];
        boolean[] col = new boolean[M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (A[i].charAt(j) == 'X') {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

        int needRow = N, needCol = M;
        for (boolean b : row) {
            if (b) needRow--;
        }
        for (boolean b : col) {
            if (b) needCol--;
        }

        sb.append(Math.max(needRow, needCol));
        System.out.println(sb);
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