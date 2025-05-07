import java.io.*;
import java.util.*;

public class Solution {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int[][] A;

    static void input() {
        A = new int[10][10];
        for (int i = 1; i <= 9; i++) for (int j = 1; j <= 9; j++) A[i][j] = scan.nextInt();
    }

    static void pro() {
        // 가로, 세로
        for (int i = 1; i <= 9; i++) {
            int sumRow = 0, sumCol = 0;
            for (int j = 1; j <= 9; j++) {
                sumRow += A[i][j];
                sumCol += A[j][i];
            }
            if (sumRow != 45 || sumCol != 45) {
                sb.append('0').append('\n');
                return;
            }
        }

        // 3 x 3
        for (int i = 1; i <= 7; i+=3) {
            for (int j = 1; j <= 7; j+=3) {
                int sum = 0;
                for (int row = i; row <= i+2; row++) {
                    for (int col = j; col <= j+2; col++) sum += A[row][col];
                }
                if (sum != 45) {
                    sb.append('0').append('\n');
                    return;
                }
            }
        }
        sb.append(1).append('\n');
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