import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();

    static void input() {
        N = scan.nextInt();
        col = new int[N + 1];
    }

    static int N, ans;
    static int[] col;

    static boolean attackable(int r1, int c1, int r2, int c2) {
        if (c1 == c2) return true; // 같은 열
        if (r1 - c1 == r2 - c2) return true; // 왼쪽 위 대각선
        if (r1 + c1 == r2 + c2) return true; // 오른쪽 위 대각선
        return false;
    }

    static void rec_func(int row) {
        if (row == N + 1) {
            ans++;
        } else {
            for (int c = 1; c <= N; c++) {
                boolean possible = true;
                // row 행의 c 열에 놓을 수 있는지
                // valid check (row, c)
                for (int i=1; i<=row-1; i++){
                    // (i, col[i])
                    if (attackable(row, c, i, col[i])) {
                        possible = false;
                        break;
                    }
                }
                if (possible) {
                    col[row] = c;
                    rec_func(row + 1);
                    col[row] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        input();
        rec_func(1);
        System.out.println(ans);
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