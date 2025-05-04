import java.io.*;
import java.util.*;

public class Solution {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[][] A;
    static int[][] dir = {{0,1}, {1,0}, {0,-1}, {-1,0}};

    static void input() {
        N = scan.nextInt();
        A = new int[N + 1][N + 1];
    }

    static void pro() {
        int x = 1, y = 1;
        A[x][y] = 1;
        int idx = 0;

        for (int i = 2; i <= N*N; i++) {
            int nx = x + dir[idx][0];
            int ny = y + dir[idx][1];

            if (nx < 1 || ny < 1 || nx > N || ny > N || A[nx][ny] != 0) {
                idx = (idx + 1) % 4;
                i--;
                continue;
            }

            A[nx][ny] = i;
            x = nx;
            y = ny;
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) sb.append(A[i][j]).append(' ');
            sb.append('\n');
        }
    }

    public static void main(String[] args) {
        int T = scan.nextInt();
        for (int t = 1; t <= T; t++) {
            sb.append('#').append(t).append('\n');
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