import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();

    static int N, total;
    static boolean[][] arr;

    static void input() {
        N = scan.nextInt();
        arr = new boolean[101][101];
    }

    static void pro() {
        while (N-- > 0) {
            int row = scan.nextInt();
            int col = scan.nextInt();
            for (int i = row; i < row + 10; i++) {
                for (int j = col; j < col + 10; j++) {
                    if (!arr[i][j]) {
                        arr[i][j] = true;
                        total++;
                    }
                }
            }
        }
        System.out.println(total);
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
    }
}