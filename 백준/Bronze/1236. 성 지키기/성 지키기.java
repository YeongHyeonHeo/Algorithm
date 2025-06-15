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
        int row = 0, col = 0;

        for (int i = 0; i < N; i++) {
            boolean flagRow = true;
            for (int j = 0; j < M; j++) {
                if (A[i].charAt(j) == 'X') {
                    flagRow = false;
                    break;
                }

            }
            if (flagRow) row++;
        }

        for (int i = 0; i < M; i++) {
            boolean flagCol = true;
            for (int j = 0; j < N; j++) {
                if (A[j].charAt(i) == 'X') {
                    flagCol = false;
                    break;
                }
            }
            if (flagCol) col++;
        }

        sb.append(Math.max(row, col));
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