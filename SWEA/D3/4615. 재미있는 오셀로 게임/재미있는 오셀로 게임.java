import java.io.*;
import java.util.*;

public class Solution {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static int[][] A;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1},
            {1, 1}, {-1, -1}, {1, -1}, {-1, 1}};

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        A = new int[N + 1][N + 1];
    }

    static void init() {
        A[N/2][N/2] = 2; A[N/2][N/2+1] = 1;
        A[N/2+1][N/2] = 1; A[N/2+1][N/2+1] = 2;
    }

    static void pro() {
        init();
        for (int i = 0; i < M; i++) {
            int col = scan.nextInt();
            int row = scan.nextInt();
            int color = scan.nextInt();
            A[row][col] = color;
            for (int j = 0; j < 8; j++) {
                int nx = row + dir[j][0];
                int ny = col + dir[j][1];
                if (nx > N || ny > N || nx < 1 || ny < 1) continue;
                if (A[nx][ny] == 0) continue;
                if (A[nx][ny] != color) {
                    boolean flag = false;
                    while (true) {
                        nx += dir[j][0];
                        ny += dir[j][1];
                        if (nx > N || ny > N || nx < 1 || ny < 1 || A[nx][ny] == 0) break;
                        if (A[nx][ny] == color) {
                            flag = true;
                            break;
                        }
                    }
                    nx = row + dir[j][0];
                    ny = col + dir[j][1];
                    if (flag) {
                        while (A[nx][ny] != color) {
                            A[nx][ny] = color;
                            nx += dir[j][0];
                            ny += dir[j][1];
                        }
                    }
                }
            }
        }

        int sum1 = 0, sum2 = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (A[i][j] == 1) sum1++;
                else if (A[i][j] == 2) sum2++;
            }
        }
        sb.append(sum1).append(' ').append(sum2).append('\n');
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